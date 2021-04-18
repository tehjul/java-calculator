package com.iut.as2021.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

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
	public void testCasAdditionSimple() {
		assertEquals(calcul.run("2 + 3"), 5, 1);
	}

	@Test
	public void testCasSoustractionSimple() {
		assertEquals(calcul.run("2 - 3"), -1, 1);
	}

	@Test
	public void testCasMultiplicationSimple() {
		calcul.setMaths(mathsMock);
		Mockito.when(mathsMock.multiplication(anyInt(), anyInt())).thenReturn(6);
		assertEquals(calcul.run("7 * 1"), 6, 1);
	}

}
