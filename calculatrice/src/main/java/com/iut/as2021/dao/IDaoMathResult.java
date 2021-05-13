package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

import java.sql.SQLException;
import java.util.List;

public interface IDaoMathResult extends IDao<MathResultat> {
    @Override
    MathResultat readById(int i) throws SQLException, ClassNotFoundException, MathsExceptions;

    @Override
    List<MathResultat> getAll();

    @Override
    boolean update(MathResultat object);

    @Override
    boolean create(MathResultat object);

    @Override
    boolean delete(MathResultat object) throws SQLException, ClassNotFoundException;
}
