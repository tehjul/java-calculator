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

	public double run(String expression) throws MathsExceptions {
		int pos = 0;
		String right;
		char operand = IutTools.getNextOperand(expression, pos);
		pos = expression.indexOf(operand);
		String left = IutTools.getLeftExpression(expression, pos);
		int result = Integer.valueOf(left);

		while (operand != 32) {
			pos = expression.indexOf(operand, pos);
			right = IutTools.getNextInt(expression, pos);
			result = applyOperator(operand, result, Integer.valueOf(right));
			pos += 1;
			operand = IutTools.getNextOperand(expression, pos);
		}

		return result;

} }
