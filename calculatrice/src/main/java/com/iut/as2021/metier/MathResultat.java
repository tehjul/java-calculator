package com.iut.as2021.metier;

import static com.iut.as2021.enumerations.EDirection.*;
import static com.iut.as2021.enumerations.EOperation.*;
import static com.iut.as2021.tools.IutTools.getLeftExpression;
import static com.iut.as2021.tools.IutTools.getRightExpression;

import com.iut.as2021.enumerations.EDirection;
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

    private int level;
    private EDirection direction;

    private MathResultat leftExpression;
    private MathResultat rightExpression;

    private static final String ZERO = "0000000";
    private static final String SPACE = "\\s";
    private static final String EMPTY_STRING = "";

    public String getExpression() {
        return expression;
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
            if (getPositionFromOperation(OPEN_BRACKET) >= 0) {
                expression = expression.replaceAll("\\" + OPEN_BRACKET.getOperateur(), EMPTY_STRING);
            }
            if (getPositionFromOperation(CLOSE_BRACKET) >= 0) {
                expression = expression.replaceAll("\\" + CLOSE_BRACKET.getOperateur(), EMPTY_STRING);
            }
            return Integer.valueOf(expression);
        }
        return calculate();
    }

    public MathResultat(String expression) throws MathsExceptions {
        this(expression, 0, INIT);
    }

    public MathResultat(String expression, int level, EDirection direction) throws MathsExceptions {
        this.operation = INCONNUE;
        this.level = level;
        this.direction = direction;
        if (expression == null || expression.isEmpty()) {
            this.expression = ZERO;
        } else {
            this.level++;
            expression = expression.replaceAll(SPACE, EMPTY_STRING);
            expression = expression.replaceAll("\\(", OPEN_BRACKET.getOperateur()).replaceAll("\\)",
                    CLOSE_BRACKET.getOperateur());
            if (level == 0) {
                System.out.println("\n" + "******* START ******* *******");
            }
            System.out.println("Processing ... : " + expression);
            this.expression = expression;
            switchLeftAndRightExpression();
        }
    }

    private void switchLeftAndRightExpression() throws MathsExceptions {
        int pos = getOperatorPos();
        if (!INCONNUE.equals(operation)) {
            leftExpression = new MathResultat(getLeftExpression(expression, pos), level, GAUCHE);
            rightExpression = new MathResultat(getRightExpression(expression, pos), level, DROITE);
        }
    }

    public double calculate() throws MathsExceptions {
        if (INCONNUE.equals(operation)) {
            throw new MathsExceptions("Calcul impossible !");
        }
        double leftVal = 0;
        double rightVal = 0;
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
            default:
                throw new MathsExceptions("Operateur mathématique inconnu !");
        }
    }

    private double calculate(EOperation ope, double leftVal, double rightVal) throws MathsExceptions {
        this.maths = new Maths();
        double resultat = 0;
        switch (ope) {
            case MULTIPLICATION:
                resultat = maths.multiplication((int) leftVal, (int) rightVal);
                break;
            case DIVISION:
                resultat = maths.division((int) leftVal, (int) rightVal);
                break;
            case ADDITION:
                resultat = maths.addition((int) leftVal, (int) rightVal);
                break;
            case SOUSTRACTION:
                resultat = maths.soustration((int) leftVal, (int) rightVal);
                break;
            default:
                throw new MathsExceptions("Operateur non autorisé dans cette fonction !");
        }
        displayToConsole(leftVal, rightVal, resultat);
        return resultat;
    }

    private void displayToConsole(double leftVal, double rightVal, double resultat) {
        System.out.println("- ------ calcul de l'arbre binaire ------ -");
        System.out.println("-> " + level + " / direction : " + direction);
        System.out.println("- Operation : " + operation);
        System.out.println("- Gauche value : " + leftVal);
        System.out.println("- Droite value : " + rightVal);
        System.out.println("-> Le Resultat est = " + resultat);
        if (level == 1) {
            System.out.println("******* END ******* ******* FINAL : " + resultat);
        }
    }

    private int getOperatorPos() {
        return findOperator(findBrackets());
    }

    private int findBrackets() {
        int pos = getPositionFromOperation(CLOSE_BRACKET_A);
        if (pos >= 0) {
            this.operation = ADDITION;
        } else {
            pos = getPositionFromOperation(CLOSE_BRACKET_S);
            if (pos >= 0) {
                this.operation = SOUSTRACTION;
            } else {
                pos = getPositionFromOperation(CLOSE_BRACKET_M);
                if (pos >= 0) {
                    this.operation = MULTIPLICATION;
                } else {
                    pos = getPositionFromOperation(CLOSE_BRACKET_D);
                    if (pos >= 0) {
                        this.operation = DIVISION;
                    }
                }
            }
        }
        if (pos >= 0) {
            pos++;
        }
        return pos;
    }

    private int findOperator(int pos) {
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

    public int getId() {
        return this.id;
    }
}