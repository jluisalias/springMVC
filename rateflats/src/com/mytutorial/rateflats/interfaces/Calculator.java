package com.mytutorial.rateflats.interfaces;

import javax.naming.directory.InvalidAttributesException;

public interface Calculator {
	public Double calculate(Double rateArea, Double rateRating,
			Double ratePrice, Double rateDistance) throws InvalidAttributesException;
}
