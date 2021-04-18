package com.iut.as2021.mathematics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.interfaces.IMaths;

public class MathsTest {

	private IMaths maths;
	private IMaths mathsMock;

	@Before
	public void setUp() {
		this.maths = new Maths();
		this.mathsMock = Mockito.mock(Maths.class);
		Mockito.when(mathsMock.addition(anyInt(), anyInt())).thenReturn(7);
	}

	@Test
	public void testAdditionAvecMock() {
		assertEquals(mathsMock.addition(2, 3), 7);
	}

	@Test
	public void testAdditionCasGeneralNombresPositifs() {
		assertEquals(maths.addition(2, 3), 5);
	}

	@Test(expected = MathsExceptions.class)
	public void testDivisionParZero() throws MathsExceptions {
		try {
			maths.division(4, 0);
		} catch (MathsExceptions e) {
			Assert.assertEquals(e.getMessage(), "Division par zero impossible");
			throw e;
		}
	}
}
