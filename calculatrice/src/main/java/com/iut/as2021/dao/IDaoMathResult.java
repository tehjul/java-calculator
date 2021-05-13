package com.iut.as2021.dao;

import com.iut.as2021.metier.MathResultat;

import java.util.List;

public interface IDaoMathResult extends IDao<MathResultat> {
    @Override
    MathResultat readyById(int i);

    @Override
    List<MathResultat> getAll();

    @Override
    boolean update(MathResultat object);

    @Override
    boolean create(MathResultat object);

    @Override
    boolean delete(MathResultat object);
}
