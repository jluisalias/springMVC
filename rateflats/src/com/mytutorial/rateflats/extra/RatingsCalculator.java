package com.mytutorial.rateflats.extra;

import javax.naming.directory.InvalidAttributesException;

import com.mytutorial.rateflats.interfaces.Calculator;

public class RatingsCalculator implements Calculator{
    
    private Double areaWeight;
    private Double rateWeight;
    private Double priceWeight;
    private Double distanceWeight;
    
    public RatingsCalculator() {
		super();
	}

	public RatingsCalculator(Double areaWeight, Double rateWeight,
			Double priceWeight, Double distanceWeight) {
		super();
		this.areaWeight = areaWeight;
		this.rateWeight = rateWeight;
		this.priceWeight = priceWeight;
		this.distanceWeight = distanceWeight;
	}
	
    public Double getAreaWeight() {
		return areaWeight;
	}
    public void setAreaWeight(Double areaWeight) {
		this.areaWeight = areaWeight;
	}

	public Double getRateWeight() {
		return rateWeight;
	}
	public void setRateWeight(Double rateWeight) {
		this.rateWeight = rateWeight;
	}

	public Double getPriceWeight() {
		return priceWeight;
	}
	public void setPriceWeight(Double priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Double getDistanceWeight() {
		return distanceWeight;
	}
	public void setDistanceWeight(Double distanceWeight) {
		this.distanceWeight = distanceWeight;
	}

	public Double calculate(Double rateArea, Double rateRating,
			Double ratePrice, Double rateDistance) throws InvalidAttributesException {
		// TODO Auto-generated method stub
		Double denominator = areaWeight + rateWeight + priceWeight + distanceWeight;
		if(denominator==0){
			throw new InvalidAttributesException("La suma de los pesos no puede ser 0");
		}
    	Double result = areaWeight*rateArea/denominator;
    	result += rateWeight*rateRating/denominator;
    	result += priceWeight*ratePrice/denominator;
    	result += distanceWeight*rateDistance/denominator;
		return result;
	}
}
