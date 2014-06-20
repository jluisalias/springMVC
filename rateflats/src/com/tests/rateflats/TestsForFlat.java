package com.tests.rateflats;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mytutorial.rateflats.Flat;

public class TestsForFlat {
	
	public Flat flatSUT;

	@Before
	public void setUp() throws Exception {
		flatSUT = new Flat();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReturnRateDistanceMustReturnBiggerRateAtSmallerDistance() {
		flatSUT.setDistanceToWork(200);
		double rate1 = flatSUT.returnRateDistance();
		flatSUT.setDistanceToWork(1500);
		double rate2 = flatSUT.returnRateDistance();
		assertNotEquals(rate1, rate2);
		boolean bigger = rate1 > rate2;
		assertTrue(bigger);
	}
	
	@Test
	public void testReturnRatePriceMustReturnBiggerRateAtSmallerPrice() {
		flatSUT.setPriceByMonth(350);
		double rate1 = flatSUT.returnRatePrice();
		flatSUT.setPriceByMonth(360);
		double rate2 = flatSUT.returnRatePrice();
		assertNotEquals(rate1, rate2);
		boolean bigger = rate1 > rate2;
		assertTrue(bigger);
	}
	
	@Test
	public void testReturnRateAreaMustReturnBiggerRateAtBiggerArea() {
		flatSUT.setAreaSize(82);
		double rate1 = flatSUT.returnRateArea();
		flatSUT.setAreaSize(50);
		double rate2 = flatSUT.returnRateArea();
		assertNotEquals(rate1, rate2);
		boolean bigger = rate1 > rate2;
		assertTrue(bigger);
	}
	
	@Test
	public void testCompareTo() {
		flatSUT.setFinalRating(9.0);
		Flat otherFlat = new Flat();
		otherFlat.setFinalRating(5.0);
		int compareToRes = flatSUT.compareTo(otherFlat);
		assertTrue(compareToRes>0);
	}
	
}
