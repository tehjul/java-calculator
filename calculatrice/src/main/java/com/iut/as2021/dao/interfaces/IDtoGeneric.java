package com.iut.as2021.dao.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;

public interface IDtoGeneric<T1, T2> {

    T1 adapt(T2 object) throws MathsExceptions;

    T1 adaptById(Integer id);

    T2 unadapt(T1 object);
}
