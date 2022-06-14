package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iut.as2021.exceptions.MathsExceptions;

public class MathResultatTest {

    private MathResultat resultat;

    @Test
    public void _00_testExpressionEstVide() throws MathsExceptions {
        resultat = new MathResultat("");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _01_testExpressionEstNull() throws MathsExceptions {
        resultat = new MathResultat(null);
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _02_testExpressionSimpleAddition() throws MathsExceptions {
        resultat = new MathResultat("2 + 3");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test
    public void _03_testExpressionSimpleSoustraction() throws MathsExceptions {
        resultat = new MathResultat("2 - 3");
        assertEquals(resultat.getValue(), -1, 0);
    }

    @Test
    public void _04_testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new MathResultat("9 * 8");
        assertEquals(resultat.getValue(), 72, 0);
    }

    @Test
    public void _05_testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new MathResultat("8 / 2");
        assertEquals(resultat.getValue(), 4, 0);
    }

    @Test
    public void _06_testExpressionWithBracketSimpleMultiplication() throws MathsExceptions {
        resultat = new MathResultat("(2 + 3) * 7");
        assertEquals(resultat.getValue(), 35, 0);
    }

    @Test
    public void _07_testExpressionWithBracketSimpleAddition() throws MathsExceptions {
        resultat = new MathResultat("(2 + 3) + 7");
        assertEquals(resultat.getValue(), 12, 0);
    }

    @Test
    public void _08_testExpressionWithBracketSimpleDivision() throws MathsExceptions {
        resultat = new MathResultat("(8 + 4) / 3");
        assertEquals(resultat.getValue(), 4, 0);
    }

    @Test
    public void _09_testExpressionWithBracketSimpleSoustraction() throws MathsExceptions {
        resultat = new MathResultat("(8 + 4) - 3");
        assertEquals(resultat.getValue(), 9, 0);
    }

    @Test
    public void _10_testExpressionSimpleAdditionMultiples() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 - 1 + 7 + 8");
        assertEquals(resultat.getValue(), 19, 0);
    }

    @Test
    public void _11_testExpressionSimpleSoustractionMultiple() throws MathsExceptions {
        resultat = new MathResultat("7 - 3 + 1");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test
    public void _12_testExpressionSimpleAvecMultiplication() throws MathsExceptions {
        resultat = new MathResultat("7 + 1 * 3 + 1");
        assertEquals(resultat.getValue(), 11, 0);
    }

    @Test
    public void _13_testExpressionComplexe() throws MathsExceptions {
        resultat = new MathResultat("7 + 4 * 3 * 4 + 1");
        assertEquals(resultat.getValue(), 56, 0);
    }

    @Test
    public void _14_testExpressionSimpleAdditionExpressionErronnee() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 + ");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test
    public void _15_testExpressionPriorityToMultiply() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 * 5 - 1 + 2");
        assertEquals(resultat.getValue(), 18, 0);
    }

    @Test
    public void _16_testExpressionPriorityToSeveralMultiply() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 * 5 * 2 + 7");
        assertEquals(resultat.getValue(), 39, 0);
    }

    @Test
    public void _17_testExpressionSimpleAdditionWithBracket() throws MathsExceptions {
        resultat = new MathResultat("(2 + 3) + 11");
        assertEquals(resultat.getValue(), 16, 0);
    }

    @Test
    public void _18_testExpressionSimpleAdditionWithTwoBrackets() throws MathsExceptions {
        resultat = new MathResultat("(2 + 5) + (1 * 5)");
        assertEquals(resultat.getValue(), 12, 0);
    }

    @Test
    public void _19_testExpressionSimpleAdditionWithSeveralBrackets() throws MathsExceptions {
        resultat = new MathResultat("((((2 + 3)) * ((4 + 5))))");
        assertEquals(resultat.getValue(), 45, 0);
    }

    @Test
    public void _20_testExpressionSimpleAdditionWithTwoBracketsAndMultiply() throws MathsExceptions {
        resultat = new MathResultat("(2 + 5) * (1 + 3)");
        assertEquals(resultat.getValue(), 28, 0);
    }

    @Test
    public void _21_testExpressionMultiplicationAndAddition() throws MathsExceptions {
        resultat = new MathResultat("7 + 4 * 3 + 2 + 1");
        assertEquals(resultat.getValue(), 22, 0);
    }

    @Test
    public void _22_testExpressionSimpleAdditionWithSeveralBracketsPlus() throws MathsExceptions {
        resultat = new MathResultat("(((2 + 3)) * (4 + 5) + 2)");
        assertEquals(resultat.getValue(), 47, 0);
    }

    @Test
    public void _23_testExpressionComplexWithSeveralBrackets() throws MathsExceptions {
        resultat = new MathResultat("(((((2 + 3)) * ((4 + 5)) + 2)))");
        assertEquals(resultat.getValue(), 47, 0);
    }

    @Test
    public void _24_testExpressionComplexWithSeveralBrackets2() throws MathsExceptions {
        resultat = new MathResultat("((((((2 + 3)) * ((4 + 5)) + 2))) + 3) * 2");
        assertEquals(resultat.getValue(), 100, 0);
    }

    @Test
    public void _25_testExpressionComplexWithSeveralBrackets3() throws MathsExceptions {
        resultat = new MathResultat("((((((2 + 3)) * ((4 + 5)) + 2))) + 3 * 2");
        assertEquals(resultat.getValue(), 53, 0);
    }

    @Test
    public void _26_testExpression() throws MathsExceptions {
        resultat = new MathResultat("8 - 9");
        assertEquals(resultat.getValue(), -1, 0);
    }

    @Test
    public void _27_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(8 * 1) * 1 * 1");
        assertEquals(resultat.getValue(), 8, 0);
    }

    @Test
    public void _28_testExpression() throws MathsExceptions {
        resultat = new MathResultat("53");
        assertEquals(resultat.getValue(), 53, 0);
    }

    @Test
    public void _29_testExpression() throws MathsExceptions {
        resultat = new MathResultat("1-1");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _30_testExpression() throws MathsExceptions {
        resultat = new MathResultat("7-7");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _31_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(4 / 2) * 2");
        assertEquals(resultat.getValue(), 4, 0);
    }

    @Test
    public void _32_testExpression() throws MathsExceptions {
        resultat = new MathResultat("1 * 7 * 3");
        assertEquals(resultat.getValue(), 21, 0);
    }

    @Test
    public void _33_testExpression() throws MathsExceptions {
        resultat = new MathResultat("0 * (0 + 0)");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void _34_testExpression() throws MathsExceptions {
        resultat = new MathResultat("fdsffddsffsdfsdf");
        assertEquals(resultat.getValue(), 53, 0);
    }

    @Test
    public void _35_testExpression() throws MathsExceptions {
        resultat = new MathResultat("6 * 1 - 1");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test
    public void _36_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(5 * 4) * 1");
        assertEquals(resultat.getValue(), 20, 0);
    }

    @Test
    public void _37_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(((2 * 3)))");
        assertEquals(resultat.getValue(), 6, 0);
    }

    @Test
    public void _38_testExpression() throws MathsExceptions {
        resultat = new MathResultat("((2 * 3) + 1)");
        assertEquals(resultat.getValue(), 7, 0);
    }

    @Test
    public void _39_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(2 * 0) * 7 / 1");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _40_testExpression() throws MathsExceptions {
        resultat = new MathResultat("0*3");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _41_testExpression() throws MathsExceptions {
        resultat = new MathResultat("56");
        assertEquals(resultat.getValue(), 56, 0);
    }

    @Test
    public void _42_testExpression() throws MathsExceptions {
        resultat = new MathResultat("9999999");
        assertEquals(resultat.getValue(), 9999999, 0);
    }

    @Test
    public void _43_testExpression() throws MathsExceptions {
        resultat = new MathResultat("2 * 3");
        assertEquals(resultat.getValue(), 6, 0);
    }

    @Test
    public void _44_testExpression() throws MathsExceptions {
        resultat = new MathResultat("2 * 3 - 1");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test
    public void _45_testExpression() throws MathsExceptions {
        resultat = new MathResultat("2 * 3 - 2");
        assertEquals(resultat.getValue(), 4, 0);
    }

    @Test
    public void _46_testExpression() throws MathsExceptions {
        resultat = new MathResultat("((2 * 3)) * ((2 * 3))");
        assertEquals(resultat.getValue(), 36, 0);
    }

    @Test
    public void _47_testExpression() throws MathsExceptions {
        resultat = new MathResultat("(2 * 3) * 0");
        assertEquals(resultat.getValue(), 0, 0);
    }

    @Test
    public void _48_testExpression() throws MathsExceptions {
        resultat = new MathResultat("2 * 3 - 1 * 1");
        assertEquals(resultat.getValue(), 5, 0);
    }

    @Test(expected = MathsExceptions.class)
    public void _49_testExpression() throws MathsExceptions {
        resultat = new MathResultat("0 * 0 + 0 - 0 / 0");
        assertEquals(resultat.getValue(), 6, 0);
    }
}
