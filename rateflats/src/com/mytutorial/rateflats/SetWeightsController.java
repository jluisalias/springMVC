package com.mytutorial.rateflats;

import javax.naming.directory.InvalidAttributesException;
import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytutorial.rateflats.extra.RatingsCalculator;
import com.mytutorial.rateflats.interfaces.FlatManager;

@Controller
public class SetWeightsController {
	@Autowired
    private FlatManager flatManager;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setFlatManager(FlatManager flatManager) {
        this.flatManager = flatManager;
    }
	
	@RequestMapping(value = "/setWeights", method = RequestMethod.GET)
    protected RatingsCalculator formBackingObject(@ModelAttribute("calculator") RatingsCalculator calculator,
    		BindingResult result) throws ServletException {
		calculator = new RatingsCalculator();
        return calculator;
    }
	
	@RequestMapping(value = "/setWeights", method = RequestMethod.POST)
	public String setWeights(@ModelAttribute("calculator") RatingsCalculator ratingsCalculator,
			BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			return "/setWeights";
		}
		
		double areaWeight = ratingsCalculator.getAreaWeight();
        logger.info("Area weight is: " + areaWeight + "%.");
        double rateWeight = ratingsCalculator.getRateWeight();
        logger.info("Your ratings weight is: " + rateWeight + "%.");
        double priceWeight = ratingsCalculator.getPriceWeight();
        logger.info("Price weight is: " + priceWeight + "%.");
        double distanceWeight = ratingsCalculator.getDistanceWeight();
        logger.info("Distance weight is: " + distanceWeight + "%.");

        try {
			flatManager.reCalculateRatings(ratingsCalculator);
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}

        return "/result";
	}
}
