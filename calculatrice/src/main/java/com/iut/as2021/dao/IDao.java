package com.iut.as2021.dao;

import java.util.List;

public interface IDao<T> {

    T readyById(int i);

    List<T> getAll();

    boolean update(T object);

    boolean create(T object);

    boolean delete(T object);

}
