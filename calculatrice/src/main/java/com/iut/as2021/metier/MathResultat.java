package com.iut.as2021.metier;

import static com.iut.as2021.enumerations.EOperation.ADDITION;
import static com.iut.as2021.enumerations.EOperation.CLOSE_BRACKET;
import static com.iut.as2021.enumerations.EOperation.DIVISION;
import static com.iut.as2021.enumerations.EOperation.INCONNUE;
import static com.iut.as2021.enumerations.EOperation.MULTIPLICATION;
import static com.iut.as2021.enumerations.EOperation.OPEN_BRACKET;
import static com.iut.as2021.enumerations.EOperation.SOUSTRACTION;
import static com.iut.as2021.tools.IutTools.getLeftExpression;
import static com.iut.as2021.tools.IutTools.getRightExpression;

import com.iut.as2021.enumerations.EOperation;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

/**
 * @Description : Classe 'récursive' permettant de créer un arbre binaire
 *              d'opérations.
 * Attention : cette classe est 'encore buggée' ..
 * @author : stephane.joyeux.
 *
 * @date : Mai 2021.
 */
public class MathResultat {

    private EOperation operation;
    private IMaths maths;

    private int id;
    private String expression;

    private MathResultat leftExpression;
    private MathResultat rightExpression;

    private static final String ZERO = "0000000";

    public String getExpression() {
        return expression;
    }

    public int getId() {
        return id;
    }

    protected String getLeftExp() {
        if (leftExpression != null) {
            return leftExpression.getExpression();
        }
        return "";
    }

    protected String getRightExp() {
        if (rightExpression != null) {
            return rightExpression.getExpression();
        }
        return "";
    }

    public EOperation getOperation() {
        return operation;
    }

    public double getValue() throws MathsExceptions {
        if (INCONNUE.equals(operation)) {
            return Integer.valueOf(expression);
        }
        return calculate();
    }

    public MathResultat(String expression) throws MathsExceptions {
        this.operation = INCONNUE;
        if (expression == null || expression.isEmpty()) {
            this.expression = ZERO;
        } else {
            expression = expression.replaceAll("\\(", OPEN_BRACKET.getOperateur()).replaceAll("\\)",
                    CLOSE_BRACKET.getOperateur());
            this.expression = expression;
            switchLeftAndRightExpression();
        }
    }

    public double calculate() throws MathsExceptions {
        if (INCONNUE.equals(operation)) {
            throw new MathsExceptions("Calcul impossible !");
        }
        double leftVal = 0;
        double rightVal = 0;
        EOperation internalOp = INCONNUE;
        if (leftExpression != null) {
            leftVal = leftExpression.getValue();
        }
        if (rightExpression != null) {
            rightVal = rightExpression.getValue();
        }
        switch (operation) {
            case MULTIPLICATION:
            case DIVISION:
            case ADDITION:
            case SOUSTRACTION:
                return calculate(operation, leftVal, rightVal);
            case OPEN_BRACKET:
                internalOp = getOpeAccordingOperateur(getLeftExp(), true);
                if (INCONNUE.equals(internalOp) || leftVal == 0) {
                    return rightVal;
                }
                return calculate(internalOp, leftVal, rightVal);
            case CLOSE_BRACKET:
                internalOp = getOpeAccordingOperateur(getRightExp(), false);
                if (INCONNUE.equals(internalOp) || rightVal == 0) {
                    return leftVal;
                }
                return calculate(internalOp, leftVal, rightVal);
            default:
                throw new MathsExceptions("Operateur mathématique inconnu !");
        }
    }

    private double calculate(EOperation ope, double leftVal, double rightVal) throws MathsExceptions {
        this.maths = new Maths();
        switch (ope) {
            case MULTIPLICATION:
                return maths.multiplication((int) leftVal, (int) rightVal);
            case DIVISION:
                return maths.division((int) leftVal, (int) rightVal);
            case ADDITION:
                return maths.addition((int) leftVal, (int) rightVal);
            case SOUSTRACTION:
                return maths.soustration((int) leftVal, (int) rightVal);
            default:
                throw new MathsExceptions("Operateur non autorisé dans cette fonction !");
        }
    }

    private void switchLeftAndRightExpression() throws MathsExceptions {
        int pos = getPosition();
        if (!INCONNUE.equals(operation) && pos >= 0) {
            leftExpression = new MathResultat(getLeftExpression(expression, pos));
            rightExpression = new MathResultat(getRightExpression(expression, pos));
        }
    }

    private int getPosition() {
        int pos = getPositionFromOperation(OPEN_BRACKET);
        if (pos < 0) {
            pos = getPositionFromOperation(CLOSE_BRACKET);
        }
        if (pos < 0) {
            pos = getPositionFromOperation(ADDITION);
        }
        if (pos < 0) {
            pos = getPositionFromOperation(SOUSTRACTION);
        }
        if (pos < 0) {
            pos = getPositionFromOperation(MULTIPLICATION);
        }
        if (pos < 0) {
            pos = getPositionFromOperation(DIVISION);
        }
        return pos;
    }

    private int getPositionFromOperation(EOperation operation) {
        int pos = this.expression.indexOf(operation.getOperateur());
        if (pos >= 0) {
            this.operation = operation;
        }
        return pos;
    }

    private EOperation getOpeAccordingOperateur(String expression, boolean left) {
        String operateur = null;
        if (left) {
            operateur = expression.substring(expression.length() - 1);
        } else {
            operateur = expression.substring(0, 1);
        }
        if (operateur != null && !operateur.isEmpty()) {
            if (ADDITION.getOperateur().equals(operateur)) {
                return ADDITION;
            }
            if (SOUSTRACTION.getOperateur().equals(operateur)) {
                return SOUSTRACTION;
            }
            if (MULTIPLICATION.getOperateur().equals(operateur)) {
                return MULTIPLICATION;
            }
            if (DIVISION.getOperateur().equals(operateur)) {
                return DIVISION;
            }
        }
        return INCONNUE;
    }
}