package com.iut.as2021.dao.interfaces;

public interface IDtoGeneric<T1, T2> {

    T1 adapt(T2 object);

    T1 adaptById(Integer id);

    T2 unadapt(T1 object);
}
