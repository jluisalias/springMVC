package com.mytutorial.rateflats.extra;

import com.mytutorial.rateflats.interfaces.Calculator;

public class RatingsCalculator implements Calculator{
    
    private Double areaWeight;
    private Double rateWeight;
    private Double priceWeight;
    private Double distanceWeight;
	
    public Double getAreaWeight() {
		return areaWeight;
	}

	public Double getRateWeight() {
		return rateWeight;
	}

	public Double getPriceWeight() {
		return priceWeight;
	}

	public Double getDistanceWeight() {
		return distanceWeight;
	}

	public RatingsCalculator(Double areaWeight, Double rateWeight,
			Double priceWeight, Double distanceWeight) {
		super();
		try{
			this.areaWeight = areaWeight;
			this.rateWeight = rateWeight;
			this.priceWeight = priceWeight;
			this.distanceWeight = distanceWeight;
		}
		catch(IndexOutOfBoundsException ex){
			System.out.println("Los pesos deben estar entre 0 y 1");
		    ex.printStackTrace();
		}
		if((areaWeight+rateWeight+priceWeight+distanceWeight)>1){
			throw new IndexOutOfBoundsException("Los pesos deben sumar"
					+ " como mucho 1");
		}
	}

	public Double calculate(Double rateArea, Double rateRating,
			Double ratePrice, Double rateDistance) {
		// TODO Auto-generated method stub
    	Double result = areaWeight*rateArea;
    	result += rateWeight*rateRating;
    	result += priceWeight*ratePrice;
    	result += distanceWeight*rateDistance;
		return null;
	}
    
}
