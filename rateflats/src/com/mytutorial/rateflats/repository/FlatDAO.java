package com.mytutorial.rateflats.repository;

import java.util.List;

import com.mytutorial.rateflats.Flat;

public interface FlatDAO {
	
	public void createNewFlat(Flat newFlat);
	
	public void saveFlat(Flat flatToSave);
    
    public List<Flat> getAllFlats();
    
    public List<Flat> searchFlatsByName(String keyFlat);
    
    public Flat searchOneFlatById(int flatId);
    
    public void removeFlatWithId(int flatId);
}
