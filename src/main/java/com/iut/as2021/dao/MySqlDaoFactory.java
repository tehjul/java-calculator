package com.iut.as2021.dao;

import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.dao.interfaces.modele.IDaoMathResultat;

public class MySqlDaoFactory extends DaoFactoryGeneric {

    @Override
    public IDaoMathResultat getDaoMathResult() {
        throw new UnsupportedOperationException();
    }
}
