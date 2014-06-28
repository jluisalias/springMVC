package com.mytutorial.rateflats.extra;

import java.util.Collections;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mytutorial.rateflats.Flat;
import com.mytutorial.rateflats.interfaces.FlatManager;
import com.mytutorial.rateflats.repository.FlatDAO;

@Component
public class RealFlatManager implements FlatManager {
	
private static final long serialVersionUID = 1L;
	
	@Autowired
    private FlatDAO flatDAO;

    public void setFlatDAO(FlatDAO flatDAO) {
        this.flatDAO = flatDAO;
    }

	public void createNewFlat(Flat newFlat) throws InvalidAttributesException {
		// TODO Auto-generated method stub
		RatingsCalculator ratingsCalculator = new RatingsCalculator(1.0, 1.0, 1.0, 1.0);
		newFlat.setFinalRating(ratingsCalculator.calculate(newFlat.returnRateArea(), 
				newFlat.getMyRating(), newFlat.returnRatePrice(), 
				newFlat.returnRateDistance()));
		flatDAO.createNewFlat(newFlat);
	}

	public void saveFlat(Flat flatToSave) {
		// TODO Auto-generated method stub
		flatDAO.saveFlat(flatToSave);
	}

	public List<Flat> getSortedFlats() {
		// TODO Auto-generated method stub
		List<Flat> result = flatDAO.getAllFlats();
		Collections.reverse(result);
		return result;
	}

	public void reCalculateRatings(RatingsCalculator ratingsCalculator) throws InvalidAttributesException {
		// TODO Auto-generated method stub
		List<Flat> result = flatDAO.getAllFlats();
		for(Flat flat : result){
			flat.setFinalRating(ratingsCalculator.calculate(flat.returnRateArea(), 
					flat.getMyRating(), flat.returnRatePrice(), 
					flat.returnRateDistance()));
			flatDAO.saveFlat(flat);
		}
	}

	public List<Flat> searchFlats(String keyFlat) {
		List<Flat> result = flatDAO.searchFlatsByName(keyFlat);
		return result;
	}

	public Flat searchOneFlatById(int flatId) {
		return flatDAO.searchOneFlatById(flatId);
	}

	public void removeFlatWithId(int flatId) {
		flatDAO.removeFlatWithId(flatId);		
	}

}
