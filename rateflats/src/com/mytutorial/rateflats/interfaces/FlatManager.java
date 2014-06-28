package com.mytutorial.rateflats.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.mytutorial.rateflats.Flat;
import com.mytutorial.rateflats.extra.RatingsCalculator;

public interface FlatManager extends Serializable {

	public void createNewFlat(Flat newFlat) throws InvalidAttributesException;
	
	public void saveFlat(Flat flatToSave);
    
    public List<Flat> getSortedFlats();
    
    public List<Flat> searchFlats(String keyFlat);
    
    public Flat searchOneFlatById(int flatId);
    
    public void removeFlatWithId(int flatId);

	public void reCalculateRatings(RatingsCalculator ratingsCalculator) throws InvalidAttributesException;
}
