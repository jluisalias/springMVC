package com.mytutorial.rateflats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.InvalidAttributesException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mytutorial.rateflats.interfaces.FlatManager;

@Controller
public class ManageFlatController {
	@Autowired
    private FlatManager flatManager;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setFlatManager(FlatManager flatManager) {
        this.flatManager = flatManager;
    }
	
	@RequestMapping(value = "/detailsFlat")
	public ModelAndView openFlat(@RequestParam("id")int flatId, 
			HttpServletRequest request, HttpServletResponse response) {
		
		Flat flatToOpen = this.flatManager.searchOneFlatById(flatId);
        logger.info("Opening the flat" + flatToOpen.getNameOfStreetandNumber());
        
        Map<String, Object> myModel = new HashMap<String, Object>();

        myModel.put("flat", flatToOpen);

        return new ModelAndView("detailsFlat", "model", myModel);
	}
	
	@RequestMapping(value = "/newFlat", method = RequestMethod.GET)
    protected Flat newFlatFormBackingObject(@ModelAttribute("flat") Flat newFlat,
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
