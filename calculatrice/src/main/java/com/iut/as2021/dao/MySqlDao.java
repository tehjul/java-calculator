package com.iut.as2021.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.iut.as2021.dao.connexion.Connexion;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlDao implements IDaoMathResult {

    private static IDaoMathResult instance;
    private Connection connection = null;

    private MySqlDao() {
        try{
            connection = Connexion.creeConnexion();
        } catch (SQLException e) {
            // beurk..
            System.out.println("Connexion vers la db indisponible ..");
        }
    }

    public static IDaoMathResult getInstance(){
        if (instance == null){
            return new MySqlDao();
        }
        return instance;
    }

    @Override
    public MathResultat readById(int id) throws SQLException, MathsExceptions {
        MathResultat mathresultat = null;
        String sql = "SELECT expression FROM calculatrice WHERE id = ?";
        PreparedStatement request = connection.prepareStatement(sql);
        request.setInt(1, id);
        ResultSet res = request.executeQuery();
        while (res.next()) {
            String expression = res.getString("expression");
            mathresultat = new MathResultat(expression);
        }

        return mathresultat;
    }

    @Override
    public List<MathResultat> getAll() throws SQLException, MathsExceptions {
        List<MathResultat> liste = new ArrayList<>();
        MathResultat m = null;
        String sql = "SELECT expression FROM calculatrice";
        PreparedStatement requete = connection.prepareStatement(sql);
        ResultSet res = requete.executeQuery(sql);
        while (res.next()) {
            m = new MathResultat(res.getString("expression"));
            liste.add(m);
        }

        return liste;
    }

    @Override
    public boolean update(MathResultat m) throws SQLException {
        int nbLignes = 0;
        String sql = "UPDATE calculatrice SET expression = ? WHERE id = ?";
        PreparedStatement requete = connection.prepareStatement(sql);
        requete.setString(1, m.getExpression());
        requete.setInt(2, m.getId());
        nbLignes = requete.executeUpdate();

        return nbLignes == 1;
    }

    @Override
    public boolean create(MathResultat m) throws SQLException {
        int nbLignes = 0;
        String sql = "INSERT INTO calculatrice (expression) VALUES (?)";
        PreparedStatement requete = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        requete.setInt(1, m.getId());
        nbLignes = requete.executeUpdate();

        return nbLignes==1;
    }

    @Override
    public boolean delete(MathResultat m) throws SQLException {
        int nbLignes = 0;
        String sql = "DELETE FROM calculatrice WHERE id=?";
        PreparedStatement requete = connection.prepareStatement(sql);
        requete.setInt(1, m.getId());
        nbLignes = requete.executeUpdate();

        return nbLignes==1;
    }

}