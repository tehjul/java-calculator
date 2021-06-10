package com.iut.as2021.dao.factory;

import com.iut.as2021.dao.ETypeDao;
import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.dao.MySqlDaoFactory;
import com.iut.as2021.dao.interfaces.modele.IDaoMathResultat;

public abstract class DaoFactoryGeneric {

    public static DaoFactoryGeneric getDAOFactory(ETypeDao cible) {
        DaoFactoryGeneric daoF = null;
        switch (cible) {
            case MYSQL:
                daoF = new MySqlDaoFactory();
                break;
            case XML:
                daoF = null;
                break;
        }
        return daoF;
    }

    public abstract IDaoMathResultat getDaoMathResult();

}