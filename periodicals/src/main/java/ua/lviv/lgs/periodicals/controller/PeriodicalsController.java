package ua.lviv.lgs.periodicals.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.periodicals.domain.Periodical;
import ua.lviv.lgs.periodicals.service.PeriodicalsService;
import ua.lviv.lgs.periodicals.service.PeroidicalsDTOHelper;

@Controller
public class PeriodicalsController {

	@Autowired
	PeriodicalsService periodicalsService;

	@RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
	public ModelAndView createPeriodical(
			@RequestParam MultipartFile image, 
			@RequestParam String name, 
			@RequestParam String description, 
			@RequestParam Double price) throws IOException {	
		periodicalsService.save(PeroidicalsDTOHelper.createEntity(image, name, description, price));		
		return new ModelAndView("redirect:/home");
	}

}