package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;

public class CalculerTestWithSpy {

	private Calculer calcul;
	private IMaths mathsSpy;

	@Before
	public void setUp() {
		mathsSpy = Mockito.spy(Maths.class);
		Mockito.when(mathsSpy.multiplication(anyInt(), anyInt())).thenReturn(6);
		calcul = new Calculer(mathsSpy);
	}

	@Test
	public void testCasAdditionSimple() {
		assertEquals(calcul.run("2 + 3"), 5, 1);
	}

	@Test
	public void testCasSoustractionSimple() {
		assertEquals(calcul.run("5 - 3"), 2, 1);
	}

	@Test
	public void testCasMultiplicationSimple() {
		assertEquals(calcul.run("7 * 1"), 6, 1);
	}
}
