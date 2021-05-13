package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    T readById(int i) throws SQLException, ClassNotFoundException, MathsExceptions;

    List<T> getAll();

    boolean update(T object);

    boolean create(T object);

    boolean delete(T object);

}
