package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    T readById(int i) throws SQLException, ClassNotFoundException, MathsExceptions;

    T getlasdt() throws Exception;

    List<T> getAll();

    boolean update(T object);

    boolean create(T object) throws SQLException, ClassNotFoundException;

    boolean delete(T object) throws SQLException, ClassNotFoundException;

}
