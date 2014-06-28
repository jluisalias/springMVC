package com.mytutorial.rateflats;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributesException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			BindingResult result, HttpServletRequest request, ModelMap model) {
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

        String redirectUrl = request.getScheme() + "://localhost:8080/rateflats/";
        return "redirect:" + redirectUrl;
	}
	
	@RequestMapping(value = "/editFlat", method = RequestMethod.GET)
	public ModelAndView preEditFlat(@RequestParam("id")int flatId, @ModelAttribute("flat") Flat flatToOpen,
    		BindingResult result) {
		
		flatToOpen = this.flatManager.searchOneFlatById(flatId);
        logger.info("Edit the flat" + flatToOpen.getNameOfStreetandNumber());
        
        Map<String, Object> myModel = new HashMap<String, Object>();

        myModel.put("flat", flatToOpen);

        return new ModelAndView("editFlat", "model", myModel);
	}
	
	@RequestMapping(value = "/editFlat", method = RequestMethod.POST)
	public ModelAndView editFlat(@ModelAttribute("flat") Flat flatToEdit,
			BindingResult result, @RequestParam("id")int flatId) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		
		if(result.hasErrors()){
			myModel.put("flat", flatToEdit);
			return new ModelAndView("editFlat", "model", myModel);
		}
		
		flatToEdit.setId(flatId);
		String address = flatToEdit.getNameOfStreetandNumber();
		String price = flatToEdit.getPriceByMonth().toString();
        logger.info("Edit flat with address: " + address + "and price: "+price);
        
        flatManager.saveFlat(flatToEdit);
        
        myModel.put("flat", flatToEdit);
        return new ModelAndView("detailsFlat", "model", myModel);
	}
	
	@RequestMapping(value = "/deleteFlat", method = RequestMethod.GET)
	public ModelAndView preDeleteFlat(@RequestParam("id")int flatId, 
			@ModelAttribute("flat") Flat flatToDelete, BindingResult result) {
		
		flatToDelete = this.flatManager.searchOneFlatById(flatId);
        logger.info("Edit the flat" + flatToDelete.getNameOfStreetandNumber());
        
        Map<String, Object> myModel = new HashMap<String, Object>();

        myModel.put("flat", flatToDelete);

        return new ModelAndView("areYouSure", "model", myModel);
	}
	
	@RequestMapping(value = "/deleteFlat", method = RequestMethod.POST)
	public String deleteFlat(@ModelAttribute("flat") Flat flatToDelete,
			BindingResult result, @RequestParam("id")int flatId, Model model,
			HttpServletRequest request) {
		
		flatToDelete = flatManager.searchOneFlatById(flatId);
		if(result.hasErrors()){
			model.addAttribute("flat", flatToDelete);
			return "areYouSure";
		}
		
		String address = flatToDelete.getNameOfStreetandNumber();
		String price = flatToDelete.getPriceByMonth().toString();
        logger.info("Delete Flat with address: " + address + "and price: "+price);
        
        flatManager.removeFlatWithId(flatId);
        
        String redirectUrl = request.getScheme() + "://localhost:8080/rateflats/";
        return "redirect:" + redirectUrl;
	}
}
