package com.mytutorial.rateflats;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytutorial.rateflats.interfaces.FlatManager;

@Controller
public class ListController {
	@Autowired
    private FlatManager flatManager;
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setFlatManager(FlatManager flatManager) {
        this.flatManager = flatManager;
    }
	
	@RequestMapping(value = "/listFlats", method = RequestMethod.GET)
	public String listFlats(Model model) {
		
        List<Flat> flats = this.flatManager.getSortedFlats();
        logger.info(flats.size()+" flats");

        model.addAttribute("flats", flats);

        return "/resultList";
	}
}
