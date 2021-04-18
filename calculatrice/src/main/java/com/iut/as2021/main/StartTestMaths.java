package com.iut.as2021.main;

import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

public class StartTestMaths {

	public static void main(String[] args) {
		IMaths maths = new Maths();
		System.out.println(maths.addition(2, 3));
	}
}
