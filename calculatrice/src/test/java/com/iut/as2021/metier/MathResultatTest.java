package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iut.as2021.exceptions.MathsExceptions;

public class MathResultatTest {

    private MathResultat resultat;
    // additions
    @Test
    public void testExpressionSimpleAddition() throws MathsExceptions {
        resultat = new MathResultat("2 + 3");
        assertEquals(resultat.calculate(), 5, 2);
    }
    @Test
    public void testExpressionSimpleAdditionParentheses() throws MathsExceptions {
        resultat = new MathResultat("(2 + 3)");
        assertEquals(resultat.calculate(), 5, 2);
    }
    @Test
    public void testExpressionSimpleAdditionParenthesesMultiples() throws MathsExceptions {
        resultat = new MathResultat("(((((2 + 3)))))");
        assertEquals(resultat.calculate(), 5, 2);
    }
    @Test
    public void testExpressionSimpleAdditionParenthesesMultiples2() throws MathsExceptions {
        resultat = new MathResultat("((1+1)+(1+1))");
        assertEquals(resultat.calculate(), 4, 2);
    }
    @Test
    public void testExpressionDeuxChiffresAddition() throws MathsExceptions {
        resultat = new MathResultat("20 + 30");
        assertEquals(resultat.calculate(), 50, 2);
    }
    @Test
    public void testExpressionVirguleAddition() throws MathsExceptions {
        resultat = new MathResultat("2.5 + 3.5");
        assertEquals(resultat.calculate(), 6, 2);
    }
    @Test(expected = MathsExceptions.class)
    public void testExpressionSimpleAdditionExpressionErronnee() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 + ");
        assertEquals(resultat.calculate(), 5, 2);
    }
    @Test
    public void testExpressionSimpleAdditionMultiple() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 - 1 + 7 + 8");
        assertEquals(resultat.calculate(), 19, 2);
    }

    // Soustraction
    @Test
    public void testExpressionSimpleSoustraction() throws MathsExceptions {
        resultat = new MathResultat("2 - 3");
        assertEquals(resultat.calculate(), -1, 2);
    }
    @Test
    public void testExpressionSimpleSoustractionMultiple() throws MathsExceptions {
        resultat = new MathResultat("7 - 3 + 1");
        assertEquals(resultat.calculate(), 5, 2);
    }

    // Multiplication
    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new MathResultat("7 + 1 * 3 + 1");
        assertEquals(resultat.calculate(), 11, 2);
    }

    // Division
    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new MathResultat("8 / 2");
        assertEquals(resultat.calculate(), 4, 2);
    }

    // Mélange
    @Test
    public void testCasAdditionProf() throws MathsExceptions {
        resultat = new MathResultat("1 + 2 * 3 - 1");
        assertEquals(resultat.calculate(), 6, 1);
    }
    @Test
    public void testCasDeuxMultiplications() throws MathsExceptions {
        resultat = new MathResultat("1 + 2 * 3 - 1 + 3 * 3 - 8");
        assertEquals(resultat.calculate(), 7, 1);
    }
    @Test
    public void testCasParentheses() throws MathsExceptions {
        resultat = new MathResultat("(2 + 3) * 5");
        assertEquals(resultat.calculate(), 25, 1);
    }

    // Divers
    @Test(expected = MathsExceptions.class)
    public void testExpressionSimpleNull() throws MathsExceptions {
        try {
            resultat = new MathResultat(null);
        } catch (MathsExceptions e) {
            assertEquals(e.getMessage(), "Expression est vide");
            throw e;
        }
    }
    @Test(expected = MathsExceptions.class)
    public void testExpressionMalParenthesee() throws MathsExceptions {
        try {
            resultat = new MathResultat("(1 + 2 ))");
        } catch (MathsExceptions e) {
            assertEquals(e.getMessage(), "Expression mal parenthesée");
            throw e;
        }
    }
    @Test(expected = MathsExceptions.class)
    public void testExpressionMalParenthesee2() throws MathsExceptions {
        try {
            resultat = new MathResultat("((1 + 2 )");
        } catch (MathsExceptions e) {
            assertEquals(e.getMessage(), "Expression mal parenthesée");
            throw e;
        }
    }
    @Test(expected = MathsExceptions.class)
    public void testExpressionSimpleChaineVide() throws MathsExceptions {
        try {
            resultat = new MathResultat("");
        } catch (MathsExceptions e) {
            assertEquals(e.getMessage(), "Expression est vide");
            throw e;
        }
    }
}
