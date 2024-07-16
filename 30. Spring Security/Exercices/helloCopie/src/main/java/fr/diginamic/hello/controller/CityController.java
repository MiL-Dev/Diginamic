package fr.diginamic.hello.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import fr.diginamic.hello.repositories.CityRepository;
import fr.diginamic.hello.services.CityService;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	/*
	 * @GetMapping("/cityList") public String getCities(Model model, Authentication
	 * authentication) { model.addAttribute("cities", cityService);
	 * model.addAttribute("authentication", authentication); return "city/cityList";
	 * }
	 */
	
	
	@GetMapping("/cityList")
	public ModelAndView getAllCities(Authentication authentication){
		
		Map<String, Object> model = new HashMap<>();
		
		model.put("cities", cityService.findAllCity());
		model.put("authentication", authentication);
		
		return new ModelAndView("city/cityList", model);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable int id) {
		cityService.deleteCity(id);
        return "redirect:/cityList";
    }
}
	
	
		

