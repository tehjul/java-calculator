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
        // TODO Auto-generated method stub
        return null;
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
    public boolean delete(MathResultat object) {
        // TODO Auto-generated method stub
        return false;
    }

}