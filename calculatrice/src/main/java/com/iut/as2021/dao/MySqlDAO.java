package com.iut.as2021.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

public class MySqlDAO implements IDaoMathResult {

    @Override
    public MathResultat readById(int id) throws SQLException, ClassNotFoundException, MathsExceptions {
        MathResultat mathresultat = null;

        String sql = "select * from calculatrice where id = ?";
        Connection co = MySqlConnexion.getInstance();

        PreparedStatement request = co.prepareStatement(sql);
        request.setInt(1, id);
        ResultSet res = request.executeQuery();
        if (res.next()) {
            mathresultat = new MathResultat(res.getString("expression"));
        }

        return mathresultat;
    }

    @Override
    public List<MathResultat> getAll() {
        List<MathResultat> liste = new List<>();

        List<MathResultat> listePromos = MySQLPromotionDAO.getInstance().findAll();

        String sql = "select * from calculatrice";
        Connection co = Connexion.getInstance().getConnexion();

        Statement requete = co.createStatement();
        ResultSet res = requete.executeQuery(sql);
        while (res.next()) {
            Etudiant e = new Etudiant(res.getInt("id_etudiant"), res.getString("ine_etudiant"), res.getString("nom_etudiant"), res.getString("prenom_etudiant"));
            Promotion p = new Promotion(res.getInt("id_promotion"), "xxx");
            int idx = listePromos.indexOf(p);
            e.setPromotion(listePromos.get(idx));
            liste.add(e);
        }

        return liste;
    }

    @Override
    public boolean update(MathResultat object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean create(MathResultat object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(MathResultat object) throws SQLException, ClassNotFoundException {
        String sql = "delete from calculatrice where expression=?";

        Connection co = MySqlConnexion.getInstance();
        PreparedStatement requete = co.prepareStatement(sql);
        requete.setString(1, object.getExpression());
        int nbLignes = requete.executeUpdate();

        return (nbLignes==1);
    }

}