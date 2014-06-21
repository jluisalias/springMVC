package com.mytutorial.rateflats;

import javax.naming.directory.InvalidAttributesException;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytutorial.rateflats.interfaces.FlatManager;

@Controller
public class NewFlatController {
	@Autowired
    private FlatManager flatManager;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setFlatManager(FlatManager flatManager) {
        this.flatManager = flatManager;
    }
	
	@RequestMapping(value = "/newFlat", method = RequestMethod.GET)
    protected Flat formBackingObject(@ModelAttribute("flat") Flat newFlat,
    		BindingResult result) throws ServletException {
		newFlat = new Flat();
        return newFlat;
    }
	
	@RequestMapping(value = "/newFlat", method = RequestMethod.POST)
	public String newFlat(@ModelAttribute("flat") Flat newFlat,
			BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			return "/newFlat";
		}
		
		String address = newFlat.getNameOfStreetandNumber();
		String price = newFlat.getPriceByMonth().toString();
        logger.info("New flat to insert with address: " + address + "and price: "+price);
        
        try {
			flatManager.createNewFlat(newFlat);
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}

        return "/result";
	}
}
