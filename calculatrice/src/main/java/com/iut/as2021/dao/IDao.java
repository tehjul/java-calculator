package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    T readById(int i) throws SQLException, MathsExceptions;

    List<T> getAll() throws SQLException, MathsExceptions;

    boolean update(T object) throws SQLException;

    boolean create(T object) throws SQLException;

    boolean delete(T object) throws SQLException;

}
