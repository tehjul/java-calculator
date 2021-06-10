package com.iut.as2021.dao;

import com.iut.as2021.dao.factory.DaoFactoryGeneric;

public class MainDaoFactory {

    public static void main(String[] args) {
        DaoFactoryGeneric daof = DaoFactoryGeneric.getDAOFactory(ETypeDao.MYSQL);
        //daof.getDaoMathResult().create(object);

    }

}