package com.iut.as2021.metier;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathResultatTest {
    private MathResultat resultat;

    @Test
    public void testExpressionSimpleAddition() throws MathsExceptions {
        resultat = new MathResultat("2 + 3 - 1 + 7 + 8");
        assertEquals(resultat.calculate(), 19, 2);
    }

    @Test
    public void testExpressionSimpleSoustraction() throws MathsExceptions {
        resultat = new MathResultat("7 - 3 + 1");
        assertEquals(resultat.calculate(), 5, 2);
    }

    @Test
    public void testExpressionSimpleMultiplication() throws MathsExceptions {
        resultat = new MathResultat("7 * 3");
        assertEquals(resultat.calculate(), 21, 2);
    }

    @Test
    public void testExpressionSimpleDivision() throws MathsExceptions {
        resultat = new MathResultat("8 / 2");
        assertEquals(resultat.calculate(), 4, 2);
    }
}
