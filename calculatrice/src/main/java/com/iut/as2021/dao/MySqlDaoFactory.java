package com.iut.as2021.dao;

public class MySqlDaoFactory extends DaoFactory {

    @Override
    public IDaoMathResult getDaoMathResult() {
        return MySqlDao.getInstance();
    }
}
