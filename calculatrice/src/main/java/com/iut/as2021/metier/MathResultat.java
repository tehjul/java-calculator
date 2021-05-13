package com.iut.as2021.metier;

import com.iut.as2021.enumerations.EOperation;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.tools.IutTools;

import static com.iut.as2021.enumerations.EOperation.*;

/**
 * Classe récursive permettant de créer un arbre binaire d'opérations.
 *
 * @author stephane.joyeux
 *
 */

// resultat = new MathResultat("7 - 3 + 1");
public class MathResultat {

    private EOperation operation;
    private IMaths maths;
    private String expression;
    private MathResultat leftExpression;
    private MathResultat rightExpression;

    public EOperation getOperation() {
        return operation;
    }

    public double getValue() throws MathsExceptions {
        if (INCONNUE.equals(operation)) {
            return Integer.valueOf(expression);
        }
        System.out.println("recursive");
        return calculate();
    }

    public MathResultat getLeftExpression() {
        return leftExpression;
    }

    public MathResultat getRightExpression() {
        return rightExpression;
    }

    public MathResultat(String expression) throws MathsExceptions {
        if (expression == null || expression.isEmpty()) {
            throw new MathsExceptions("Expression est vide");
        }
        this.operation = INCONNUE;
        this.expression = expression;
        System.out.println("dans constructeur, expression = " + expression);
        switchLeftAndRightExpression();
        this.maths = new Maths();
    }

    protected double calculate() throws MathsExceptions {
        if (!INCONNUE.equals(operation)) {
            double leftValue = leftExpression.getValue();
            double rightValue = rightExpression.getValue();
            switch (operation) {
                case MULTIPLICATION:
                    System.out.println("je fais la multi de " + leftValue + " et " + rightValue);
                    return maths.multiplication((int) leftValue, (int) rightValue);
                case DIVISION:
                    System.out.println("je fais la division de " + leftValue + " et " + rightValue);
                    return maths.division((int) leftValue, (int) rightValue);
                case ADDITION:
                    System.out.println("je fais l'addition de " + leftValue + " et " + rightValue);
                    return maths.addition((int) leftValue, (int) rightValue);
                case SOUSTRACTION:
                    System.out.println("je fais la soustrac de " + leftValue + " et " + rightValue);
                    return maths.soustration((int) leftValue, (int) rightValue);
                default:
                    return 0;
            }
        }
        return 0;
    }

    private void switchLeftAndRightExpression() throws MathsExceptions {
        int pos = getPosition();
        if (!INCONNUE.equals(operation) && pos > 0) {
            leftExpression = new MathResultat(IutTools.getLeftExpression(expression, pos));
            rightExpression = new MathResultat(IutTools.getRightExpression(expression, pos));
        }
    }

    private int getPosition() {
        int pos = getPositionFromOperation(ADDITION);
        if (pos <= 0) {
            pos = getPositionFromOperation(SOUSTRACTION);
        }
        if (pos <= 0) {
            pos = getPositionFromOperation(MULTIPLICATION);
        }
        if (pos <= 0) {
            pos = getPositionFromOperation(DIVISION);
        }
        return pos;
    }

    private int getPositionFromOperation(EOperation operation) {
        int pos = this.expression.indexOf(operation.getOperateur());
        if (pos > 0) {
            this.operation = operation;
            return pos;
        }
        return 0;
    }
}