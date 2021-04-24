package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iut.as2021.exceptions.MathsExceptions;

public class MathResultatTest {

    private MathResultat resultat;

    @Test
    public void testExpressionSimpleAddition() throws MathsExceptions {
        resultat = new MathResultat("2 + 3");
        assertEquals(resultat.calculate(), 5, 2);
    }

    @Test(expected = MathsExceptions.class)
    public void testExpressionSimpleAdditionExpressionErronnee() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 + ");
        assertEquals(resultat.calculate(), 5, 2);
    }

    @Test
    public void testExpressionSimpleSoustraction() throws MathsExceptions {
        resultat = new MathResultat("2 - 3");
        assertEquals(resultat.calculate(), -1, 2);
    }

    @Test
    public void testExpressionSimpleAdditionMultiple() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 - 1 + 7 + 8");
        assertEquals(resultat.calculate(), 19, 2);
    }

    @Test
    public void testExpressionSimpleSoustractionMultiple() throws MathsExceptions {
        resultat = new MathResultat("7 - 3 + 1");
        assertEquals(resultat.calculate(), 5, 2);
    }

    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new MathResultat("7 + 1 * 3 + 1");
        assertEquals(resultat.calculate(), 11, 2);
    }

    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new MathResultat("8 / 2");
        assertEquals(resultat.calculate(), 4, 2);
    }

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
    public void testExpressionSimpleChaineVide() throws MathsExceptions {
        try {
            resultat = new MathResultat("");
        } catch (MathsExceptions e) {
            assertEquals(e.getMessage(), "Expression est vide");
            throw e;
        }
    }
}
