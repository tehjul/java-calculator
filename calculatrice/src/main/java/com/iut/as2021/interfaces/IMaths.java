package com.iut.as2021.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;

public interface IMaths {

	int addition(int a, int b);

	int soustration(int a, int b);

	int multiplication(int a, int b);

	double division(int a, int b) throws MathsExceptions;
}
