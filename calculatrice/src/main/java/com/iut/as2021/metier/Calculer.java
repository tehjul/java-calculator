package com.iut.as2021.metier;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;

public class Calculer {

	private IMaths maths;

	public void setMaths(IMaths maths) {
		this.maths = maths;
	}

	public Calculer(IMaths maths) {
		this.setMaths(maths);
	}

	private double applyOperator(char operand, int firstNum, int secondNum) throws MathsExceptions {
		double result = 0;
		switch (operand) {
			case '*':
				result = maths.multiplication(firstNum, secondNum);
				break;
			case '/':
				result = maths.division(firstNum, secondNum);
				break;
			case '+':
				result = maths.addition(firstNum, secondNum);
				break;
			case '-':
				result = maths.soustration(firstNum, secondNum);
				break;
		}

		return result;
	}

	public double calc(String str) throws MathsExceptions {
		double result = 0;


		return result;
	}

	public double run(String expression) {
		int pos = 0;
		// ----------------------------------------------
		int posSigneAddition = expression.indexOf("+");
		boolean addition = (posSigneAddition > 0);
		if (addition) {
			pos = posSigneAddition;
		}
		// ------------------------------ CODE TRES DIRTY
		int posSigneSoustraction = expression.indexOf("-");
		boolean soustraction = (posSigneSoustraction > 0);
		if (soustraction) {
			pos = posSigneSoustraction;
		}
		// ------------------------------ CODE TRES DIRTY
		String left = getLeftExpression(expression, pos);
		String right = getRightExpression(expression, pos);
		if (addition) {
			double resultat = maths.addition(Integer.valueOf(left), Integer.valueOf(right));
			return resultat;
		}
		if (soustraction) {
			return maths.soustration(Integer.valueOf(left), Integer.valueOf(right));
		}
		return maths.multiplication(1, 2);
	}

	private String getRightExpression(String expression, int posSigneAddition) {
		return expression.substring(posSigneAddition + 1).trim();
	}

	private String getLeftExpression(String expression, int posSigneAddition) {
		return expression.substring(0, posSigneAddition).trim();
	}

}
