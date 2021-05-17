package com.iut.as2021.dao;

public class MainDaoFactory {

    public static void main(String[] args) {
        DaoFactory daof = DaoFactory.getDAOFactory(ETypeDao.MYSQL);
        //daof.getDaoMathResult().create(object);

    }

}