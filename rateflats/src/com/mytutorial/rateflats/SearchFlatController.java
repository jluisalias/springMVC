package com.mytutorial.rateflats;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytutorial.rateflats.interfaces.FlatManager;

@Controller
public class SearchFlatController {
	@Autowired
    private FlatManager flatManager;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setFlatManager(FlatManager flatManager) {
        this.flatManager = flatManager;
    }
	
	@RequestMapping(value = "/searchFlat", method = RequestMethod.GET)
	public String searchFlats(Model model, @ModelAttribute String searchInput, BindingResult result) {
		
		List<Flat> flats = this.flatManager.searchFlats(searchInput);
        logger.info(flats.size()+" flats found using the key \'" + searchInput + "\'");
        
        model.addAttribute("flats", flats);

        return "/resultSearch";
	}
}
