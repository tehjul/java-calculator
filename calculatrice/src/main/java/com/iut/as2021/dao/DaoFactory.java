package com.iut.as2021.dao;

public abstract class DaoFactory {

    public static DaoFactory getDAOFactory(ETypeDao cible) {
        DaoFactory daoF = null;
        switch (cible) {
            case MYSQL:
                daoF = new MySQLDaoFactory();
                break;
            case XML:
                daoF = null;
                break;
        }
        return daoF;
    }

    public abstract IDaoMathResult getDaoMathResult();
}