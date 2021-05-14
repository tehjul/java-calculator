package com.iut.as2021.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

public class MySqlDAO implements IDaoMathResult {

    @Override
    public MathResultat readById(int id) throws SQLException, ClassNotFoundException, MathsExceptions {
        MathResultat mathresultat = null;

        String sql = "select expression from calculatrice where id = ?";
        Connection co = MySqlConnexion.getInstance().getConnexion();

        PreparedStatement request = co.prepareStatement(sql);
        request.setInt(1, id);
        ResultSet res = request.executeQuery();
        if (res.next()) {
            mathresultat = new MathResultat(res.getString("expression"));
        }

        return mathresultat;
    }

    @Override
    public MathResultat getlast() throws Exception {
        MathResultat mathResultat = null;

        String sql = "SELECT * FROM calculatrice WHERE date IN (SELECT MAX(date) FROM calculatrice";

        Connection co = MySqlConnexion.getInstance().getConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        ResultSet resultSet = requete.executeQuery();
        if (resultSet.next()){
            mathResultat = new MathResultat(resultSet.getString("expression"));
            mathResultat.setId(resultSet.getInt("id"));
        }

        return mathResultat;
    }

    @Override
    public ArrayList<MathResultat> getAll() throws SQLException, MathsExceptions {
        ArrayList<MathResultat> liste = new ArrayList<>();

        String sql = "select expression from calculatrice";
        Connection co = MySqlConnexion.getInstance().getConnexion();

        Statement requete = co.createStatement();
        ResultSet res = requete.executeQuery(sql);
        while (res.next()) {
            MathResultat m = new MathResultat(res.getString("expression"));
            liste.add(m);
        }

        return liste;
    }

    @Override
    public boolean update(MathResultat m) throws SQLException {
        String sql = "UPDATE calculatrice SET expression = ? WHERE id = ?";
        Connection co = MySqlConnexion.getInstance().getConnexion();
        PreparedStatement requete = co.prepareStatement(sql);

        requete.setString(1, m.getExpression());
        requete.setInt(2, m.getId());

        int nbLignes = requete.executeUpdate();

        return nbLignes == 1;
    }

    @Override
    public boolean create(MathResultat m) throws SQLException, ClassNotFoundException {
        String sql = "insert into calculatrice (expression) values (?)";

        Connection co = MySqlConnexion.getInstance().getConnexion();
        PreparedStatement requete = co.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        requete.setInt(1, m.getId());

        int nbLignes = requete.executeUpdate();
        ResultSet res = requete.getGeneratedKeys();
        if (res.next()) {
            m.setId(res.getInt(1));
        }

        return (nbLignes==1);
    }

    @Override
    public boolean delete(MathResultat m) throws SQLException, ClassNotFoundException {
        String sql = "delete from calculatrice where id=?";

        Connection co = MySqlConnexion.getInstance().getConnexion();

        PreparedStatement requete = co.prepareStatement(sql);
        requete.setInt(1, m.getId());
        int nbLignes = requete.executeUpdate();

        return (nbLignes==1);
    }

}