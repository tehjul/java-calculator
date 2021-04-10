package tests.mathematics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.MathsExceptions;
import interfaces.IMaths;
import mathematics.Maths;

public class MathsTest {
	
	
	private IMaths maths;
	
	@Before
	public void setUp() {
		this.maths = new Maths();
	}
	
	
	@Test
	public void testAdditionCasGeneralNombrePositif() {
		Assert.assertEquals(maths.addition(2, 3), 5);
	}
	@Test
	public void testAdditionCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.addition(-2, -3), -5);
	}
	@Test
	public void testAdditionCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.addition(-2, 3), 1);
	}
	@Test
	public void testAdditionCasGeneralZero() {
		Assert.assertEquals(maths.addition(0, 0), 0);
	}
	@Test
	public void testAdditionCasGeneralPositifZero() {
		Assert.assertEquals(maths.addition(3, 0), 3);
	}
	@Test
	public void testAdditionCasGeneralNegatifZero() {
		Assert.assertEquals(maths.addition(-3, 0), -3);
	}
	
	
	
	@Test
	public void testSoustractionCasGeneralNombrePositif() {
		Assert.assertEquals(maths.soustraction(5, 3), 2);
	}
	@Test
	public void testSoustractionCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.soustraction(-5, -3), -2);
	}
	@Test
	public void testSoustractionCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.soustraction(-2, 3), -5);
	}
	@Test
	public void testSoustractionCasGeneralZero() {
		Assert.assertEquals(maths.soustraction(0, 0), 0);
	}
	@Test
	public void testSoustractionCasGeneralPositifZero() {
		Assert.assertEquals(maths.soustraction(3, 0), 3);
	}
	@Test
	public void testSoustractionCasGeneralNegatifZero() {
		Assert.assertEquals(maths.soustraction(-3, 0), -3);
	}
	
	
	
	@Test
	public void testMultiplicationCasGeneralNombrePositif() {
		Assert.assertEquals(maths.multiplication(5, 3), 15);
	}
	@Test
	public void testMultiplicationCasGeneralNombreNegatif() {
		Assert.assertEquals(maths.multiplication(-5, -3), 15);
	}
	@Test
	public void testMultiplicationCasGeneralNombresPositifNegatif() {
		Assert.assertEquals(maths.multiplication(-2, 3), -6);
	}
	@Test
	public void testMultiplicationCasGeneralZero() {
		Assert.assertEquals(maths.multiplication(0, 0), 0);
	}
	@Test
	public void testMultiplicationCasGeneralPositifZero() {
		Assert.assertEquals(maths.multiplication(3, 0), 0);
	}
	@Test
	public void testMultiplicationCasGeneralNegatifZero() {
		Assert.assertEquals(maths.multiplication(-3, 0), 0);
	}
	
	
	@Test
	public void testDivisionCasGeneralNombrePositif() throws MathsExceptions {
		Assert.assertEquals(maths.division(10, 5), 2, 2);
	}
	@Test
	public void testDivisionCasGeneralNombreNegatif() throws MathsExceptions {
		Assert.assertEquals(maths.division(-10, -5), 2, 2);
	}
	@Test
	public void testDivisionCasGeneralNombresPositifNegatif() throws MathsExceptions {
		Assert.assertEquals(maths.division(-10, 5), -2, 2);
	}
	@Test
	public void testDivisionCasGeneralPositifZero() throws MathsExceptions {
		Assert.assertEquals(maths.division(0, 3), 0, 2);
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
