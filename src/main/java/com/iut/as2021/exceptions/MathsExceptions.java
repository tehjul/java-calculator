package com.iut.as2021.exceptions;

public class MathsExceptions extends Exception {

	private static final long serialVersionUID = 1L;

	public MathsExceptions(String message) {
		super(message);
	}

	public MathsExceptions(String message, Exception e) {
		super(message, e);
	}
}
