package fr.diginamic.hello.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.repositories.CityRepository;
import fr.diginamic.hello.services.CityService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/villes")
public class CityController {

	@Autowired
	private CityService cityService;

	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private Validator validator;

	@GetMapping
	public List<City> getAllCities() {
		return cityService.extractAllCity();
	}

	@GetMapping(path = "/name/{name}")
	public City getCityByName(@PathVariable String name) {
		City ville = cityService.extractByName(name);

		return ville;
	}

	@GetMapping(path = "/id/{id}")
	public City getCityById(@PathVariable int id) {
		City ville = cityService.extractById(id);
		return ville;
	}

	@PostMapping
	public ResponseEntity<String> addVille(@RequestBody City ville) {
		//utilisation de validator pour recuperer l'erreur
		Errors errors = validator.validateObject(ville);

		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors().get(0).getDefaultMessage());
		}
//		if(serviceVille.extractByName(ville.getName()) != null) {
//			return ResponseEntity.badRequest().body("Cette ville existe deja");
//		}
		cityService.addVille(ville);
		return ResponseEntity.ok("L'ajout de la ville est un succes !");
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<String> updateCity( @PathVariable int id, @Valid @RequestBody City city, BindingResult result) {
		//utilisation de BindingResult pour recuperer l'erreur
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining("\n")));
		}
		cityService.updateCity(id, city);
		return ResponseEntity.ok("La modification de la ville est un succes !");
	}

	@PostMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteVille(@PathVariable int id) {
		cityService.deleteVille(id);
		return ResponseEntity.ok("La suppression de la ville est un succes !");
	}
	
	@GetMapping(path = "/cGetName/{name}")
	public List<City> cGetCityByName(@PathVariable String name) {
		List<City> Cities = cityRepo.findCityByName(name);

		return Cities;
	}
	
	@GetMapping(path = "/min/{min}")
	public List<City> cGetCityByName(@PathVariable int min) {
		List<City> Cities = cityRepo.findByPopulationGreaterThan(min);

		return Cities;
	}
	
	@GetMapping(path = "/between")
	public List<City> cGetCityByName(@RequestParam int min, int max) {
		List<City> Cities = cityRepo.findByPopulationBetween(min, max);

		return Cities;
	}
	
	@GetMapping(path= "/department/{code}/minpop")
	public ResponseEntity<?> getCityByDepartementSupMin(@PathVariable String code , @RequestParam int min){
		return ResponseEntity.ok(cityRepo.findByPopulationGreaterThanAndDepartmentCode(min, code));
	}
	
	@GetMapping(path= "/department/{code}/between")
	public ResponseEntity<?> getCityByDepartementBetween(@PathVariable String code , @RequestParam int min , int max){
		return ResponseEntity.ok(cityRepo.findByPopulationBetweenAndDepartmentCode(min,max, code));
	}
	
	@GetMapping(path="/paginate/{code}/page")
	public ResponseEntity<?> getAllCityByDepartmentOrderPopulation(@PathVariable String code, @RequestParam int limit){
		Pageable pageable = PageRequest.of(0, limit);
		return ResponseEntity.ok(cityRepo.findAllByDepartmentCodeOrderByPopulationDesc(code, pageable));
	}
}
