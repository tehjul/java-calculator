package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

public class CalculerTest {

	private Calculer calcul;
	private IMaths mathsMock;

	@Before
	public void setUp() {
		calcul = new Calculer(new Maths());
		mathsMock = Mockito.mock(Maths.class);
	}

	@Test
	public void testCasAdditionSimple() throws MathsExceptions {
		assertEquals(calcul.run("2 + 3"), 5, 1);
	}

	@Test
	public void testCasAdditionLongue() throws MathsExceptions {
		assertEquals(calcul.run("3 + 4 + 5 + 6"), 18, 1);
	}

	@Test
	public void testCasAdditionSoustraction() throws MathsExceptions {
		assertEquals(calcul.run("1 + 2 - 3 + 3"), 3, 1);
	}

	@Test
	public void testCasSoustractionSimple() throws MathsExceptions {
		assertEquals(calcul.run("2 - 3"), -1, 1);
	}

	@Test
	public void testCasMultiplicationSimple() throws MathsExceptions {
		calcul.setMaths(mathsMock);
		Mockito.when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(6);
		assertEquals(calcul.run("7 * 1"), 6, 1);
	}

}
