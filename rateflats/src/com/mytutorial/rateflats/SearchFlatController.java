package com.mytutorial.rateflats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView searchFlats(String searchInput, 
			HttpServletRequest request, HttpServletResponse response) {
		
		List<Flat> flats = this.flatManager.searchFlats(searchInput);
        logger.info(flats.size()+" flats found using the key \'" + searchInput + "\'");
        
        Map<String, Object> myModel = new HashMap<String, Object>();

        myModel.put("flats", flats);

        return new ModelAndView("resultSearch", "model", myModel);
	}
}
