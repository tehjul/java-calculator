package com.iut.as2021.metier;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.tools.IutTools;

public class Calculer {

	private IMaths maths;

	public void setMaths(IMaths maths) {
		this.maths = maths;
	}

	public Calculer(IMaths maths) {
		this.setMaths(maths);
	}

	private int applyOperator(char operand, int firstNum, int secondNum) throws MathsExceptions {
		int result = 0;
		switch (operand) {
			case '*':
				result = maths.multiplication(firstNum, secondNum);
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

	public int calc(String str) throws MathsExceptions {
		int result = 0;
		int pos = 0;
		char operand = IutTools.getNextOperand(str, pos);
		pos = str.indexOf(operand);
		String left = IutTools.getLeftExpression(str, pos);
		String right = IutTools.getRightExpression(str, pos);
		pos = str.indexOf(right);
		result = applyOperator(operand, Integer.valueOf(left), Integer.valueOf(right));
		operand = IutTools.getNextOperand(str, pos);
		while (operand != 32) {
			pos = str.indexOf(operand);
			right = IutTools.getRightExpression(str, pos);
			pos = str.indexOf(right);
			result = applyOperator(operand, result, Integer.valueOf(right));
			operand = IutTools.getNextOperand(str, pos);
		}

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
		String left = IutTools.getLeftExpression(expression, pos);
		String right = IutTools.getRightExpression(expression, pos);
		if (addition) {
			double resultat = maths.addition(Integer.valueOf(left), Integer.valueOf(right));
			return resultat;
		}
		if (soustraction) {
			return maths.soustration(Integer.valueOf(left), Integer.valueOf(right));
		}
		return maths.multiplication(1, 2);
	}

}
