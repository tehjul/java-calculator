package com.iut.as2021.dao.interfaces;

import java.util.List;

public interface IDaoGeneric<T> {

    void persist(T object);

    void update(T object);

    T readById(Integer id);

    void delete(T object);

    List<T> getList();
}
