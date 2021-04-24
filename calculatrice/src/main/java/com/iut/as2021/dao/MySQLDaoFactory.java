package com.iut.as2021.dao;

public class MySQLDaoFactory extends DaoFactory {

    @Override
    public IDaoMathResult getDaoMathResult() {
        return new MySqlDAO();
    }
}
