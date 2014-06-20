package com.tests.rateflats.extra;

import static org.junit.Assert.*;

import javax.naming.directory.InvalidAttributesException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mytutorial.rateflats.extra.RatingsCalculator;

public class TestForRatingsCalculator {

	public RatingsCalculator ratingsCalculatorSUT;

	@Before
	public void setUp() throws Exception {
		ratingsCalculatorSUT = new RatingsCalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRatingsCalculatorMustValuateWeights() throws InvalidAttributesException {
		ratingsCalculatorSUT.setAreaWeight(0.0);
		ratingsCalculatorSUT.setDistanceWeight(0.0);
		ratingsCalculatorSUT.setPriceWeight(0.0);
		ratingsCalculatorSUT.setRateWeight(1.0);
		Double rate1 = ratingsCalculatorSUT.calculate(5.0, 10.0, 5.0, 5.0);
		Double rate2 = ratingsCalculatorSUT.calculate(10.0, 5.0, 10.0, 10.0);
		assertNotEquals(rate1, rate2);
		boolean bigger = rate1 > rate2;
		assertTrue(bigger);
	}
	
	@Test
	public void testRatingsCalculatorMustThrowAnExceptionWhenWeightsAreZero() {
		ratingsCalculatorSUT.setAreaWeight(0.0);
		ratingsCalculatorSUT.setDistanceWeight(0.0);
		ratingsCalculatorSUT.setPriceWeight(0.0);
		ratingsCalculatorSUT.setRateWeight(0.0);
		try{
			ratingsCalculatorSUT.calculate(5.0, 5.0, 5.0, 5.0);
			fail("Debería lanzar una excepción InvalidAttributesException");
		}catch(InvalidAttributesException e)
		{
			
		}
	}

}
