package com.iut.as2021.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

public class MySqlDAO implements IDaoMathResult {

    private static IDaoMathResult instance;
    private Connection connection = null;

    private MySqlDAO() {
        try{
            connection = MySqlConnexion.getInstance().getConnexion();
        } catch (SQLException e) {
            // beurk..
            System.out.println("Connexion vers la db indisponible ..");
        }
    }

    public static IDaoMathResult getInstance(){
        if (instance == null){
            return new MySqlDAO();
        }
        return instance;
    }

    @Override
    public MathResultat readById(int id) {
        MathResultat mathresultat = null;
        try {
            String sql = "select * from calculatrice where id = ?";
            PreparedStatement request = connection.prepareStatement(sql);
            request.setInt(1, id);
            ResultSet res = request.executeQuery();
            while (res.next()) {
                String expression = res.getString("expression");
                mathresultat = new MathResultat(expression);
            }

        } catch (SQLException | MathsExceptions e) {
            // beurk
            System.out.println(e.getMessage());
        }

        return mathresultat;
    }

    @Override
    public List<MathResultat> getAll(){
        List<MathResultat> liste = new ArrayList<>();
        MathResultat m = null;
        try {
            String sql = "select expression from calculatrice";
            PreparedStatement requete = connection.prepareStatement(sql);
            ResultSet res = requete.executeQuery(sql);
            while (res.next()) {
                m = new MathResultat(res.getString("expression"));
                liste.add(m);
            }
        } catch (SQLException | MathsExceptions e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }

    @Override
    public boolean update(MathResultat m) {
        int nbLignes = 0;
        try {
            String sql = "UPDATE calculatrice SET expression = ? WHERE id = ?";
            PreparedStatement requete = connection.prepareStatement(sql);

            //requete.setString(1, m.getExpression());
            //requete.setInt(2, m.getId());

            nbLignes = requete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nbLignes == 1;
    }

    @Override
    public boolean create(MathResultat m) {
        int nbLignes = 0;
        try {
            String sql = "insert into calculatrice (expression) values (?)";
            PreparedStatement requete = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //requete.setInt(1, m.getId());

            nbLignes = requete.executeUpdate();
            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                //m.setId(res.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return (nbLignes==1);
    }

    @Override
    public boolean delete(MathResultat m) {
        int nbLignes = 0;
        try {
            String sql = "delete from calculatrice where id=?";
            PreparedStatement requete = connection.prepareStatement(sql);
            //requete.setInt(1, m.getId());
            nbLignes = requete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return (nbLignes==1);
    }

}