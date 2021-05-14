package com.iut.as2021.tools;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.metier.Calculer;
import com.iut.as2021.metier.MathResultat;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class IutToolsTest extends TestCase {

    private String test;

    @Before
    public void setUp() {
       test = "(2 + 3)";
    }

    @Test
    public void testNbParentheses() {
        assertEquals(IutTools.NbParentheses(test), 2);
    }

    public void testGetFirstClosingParenthesis() throws MathsExceptions {
        assertEquals(IutTools.getFirstClosingParenthesis(test), 6);
    }

    public void testGetLastOpeningParenthesis() throws MathsExceptions {
        assertEquals(IutTools.getLastOpeningParenthesis(test), 0);
    }

    public void testInsideExpression() throws MathsExceptions {
        MathResultat resultat = new MathResultat("2 + 3");
        assertEquals(IutTools.insideExpression(test).getExpression(), resultat.getExpression());
    }

    public void testDeleteParenthesis() {
    }
}