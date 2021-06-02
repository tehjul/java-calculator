package com.iut.as2021.dao;

import java.sql.SQLException;

public class MySqlDaoFactory extends DaoFactory {

    @Override
    public IDaoMathResult getDaoMathResult() {
        return MySqlDao.getInstance();
    }
}
