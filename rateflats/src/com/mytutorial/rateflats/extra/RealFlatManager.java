package com.mytutorial.rateflats.extra;

import java.util.Collections;
import java.util.List;

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

	public void createNewFlat(Flat newFlat) {
		// TODO Auto-generated method stub
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

	public void reCalculateRatings(RatingsCalculator ratingsCalculator) {
		// TODO Auto-generated method stub
		List<Flat> result = flatDAO.getAllFlats();
		for(Flat flat : result){
			flat.setMyRating(ratingsCalculator.calculate(flat.returnRateArea(), 
					flat.getMyRating(), flat.returnRatePrice(), 
					flat.returnRateDistance()));
		}
	}

}
