package fr.diginamic.hello.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.DocumentException;

import fr.diginamic.hello.dto.ApiDepartmentGouvDto;
import fr.diginamic.hello.dto.CityDto;
import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.exception.AnomalieException;
import fr.diginamic.hello.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/villes")
public class CityController {

	@Autowired
	private CityService cityService;

	// Utilisation de la DAO

	@GetMapping
	public List<City> getAllCities() {
		return cityService.extractAllCity();
	}

	@Operation(summary = "Recherche par nom de ville")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retourne la liste des villes incluant les characters donnee", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CityDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Si le nom de la ville n'existe pas.", content = @Content) })

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
	
	@Operation(summary = "Ajouter une ville")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ajouter la ville en base de donnee", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = City.class)) }),
			@ApiResponse(responseCode = "400", description = "Si le nom de la ville n'existe pas.", content = @Content) })
	@PostMapping
	public ResponseEntity<String> addVille(@Valid @RequestBody City city, BindingResult result)
			throws AnomalieException {
		// utilisation de validator pour recuperer l'erreur
		System.out.println(city.getDepartment().getCode());
		if (result.hasErrors()) {
			throw new AnomalieException(result.getAllErrors().get(0).getDefaultMessage());
		}
//		if(serviceVille.extractByName(ville.getName()) != null) {
//			return ResponseEntity.badRequest().body("Cette ville existe deja");
//		}
		
		cityService.addVille(city);
		return ResponseEntity.ok("L'ajout de la ville est un succes !");
	}
	
	@Operation(summary = "modifier une ville")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CityDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Si le nom de la ville n'existe pas.", content = @Content) })
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<String> updateCity(@PathVariable int id, @Valid @RequestBody City city, BindingResult result)
			throws AnomalieException {
		// utilisation de BindingResult pour recuperer l'erreur
		if (result.hasErrors()) {
			throw new AnomalieException(result.getAllErrors().get(0).getDefaultMessage());
		}
		cityService.updateCity(id, city);
		return ResponseEntity.ok("La modification de la ville est un succes !");
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteVille(@PathVariable int id) throws AnomalieException {
		if (cityService.deleteVille(id)) {
			return ResponseEntity.ok("La suppression de la ville est un succes !");
		}
		return ResponseEntity.badRequest().body("La ville n'existe pas !");
	}

	// Utilisation de la classe Repository

	@GetMapping(path = "/cGetName/{name}")
	public List<City> cGetCityByName(@PathVariable String name) {
		List<City> Cities = cityService.findCityByName(name);

		return Cities;
	}

	@GetMapping(path = "/min/{min}")
	public List<City> cGetCityByName(@PathVariable int min) {
		List<City> Cities = cityService.findByPopulationGreaterThan(min);

		return Cities;
	}

	@GetMapping(path = "/between")
	public List<City> cGetCityByName(@RequestParam int min, int max) {
		List<City> Cities = cityService.findByPopulationBetween(min, max);

		return Cities;
	}

	@GetMapping(path = "/department/{code}/minpop")
	public ResponseEntity<?> getCityByDepartementSupMin(@PathVariable String code, @RequestParam int min) {
		return ResponseEntity.ok(cityService.findByPopulationGreaterThanAndDepartmentCode(min, code));
	}

	@GetMapping(path = "/department/{code}/between")
	public ResponseEntity<?> getCityByDepartementBetween(@PathVariable String code, @RequestParam int min, int max) {
		return ResponseEntity.ok(cityService.findByPopulationBetweenAndDepartmentCode(min, max, code));
	}

	@GetMapping(path = "/paginate/{code}/page")
	public ResponseEntity<?> getAllCityByDepartmentOrderPopulation(@PathVariable String code, @RequestParam int limit) {
		Pageable pageable = PageRequest.of(0, limit);
		return ResponseEntity.ok(cityService.findAllByDepartmentCodeOrderByPopulationDesc(code, pageable));
	}

	// Utilisation de la DTO

	@GetMapping(path = "/dto")
	public List<CityDto> getAllCityDto() {

		return cityService.allCities();
	}
	//Fichier CSV
	
	@GetMapping("/population/{min}/file")
	public void fileCityCsv(@PathVariable int min,HttpServletResponse response) throws IOException, DocumentException {
		response.setHeader("Content-Disposition", "attachment; filename=\"fichierCsv.csv\"");
		
		List<CityDto> cities = cityService.findByNbHabsMin(min);
		
		response.getWriter().append("Nom ville;Popupaltion;Code Dept;Nom Dept;\n");
		
		//Cle = code - Valeur = nom de departement
		HashMap<String, String> mapCodeNameDepartment = new HashMap<>();
		
		for(CityDto dto : cities) {
			String nameDepartment = mapCodeNameDepartment.get(dto.getCodeDepartment());
			if(nameDepartment == null) {
				RestTemplate template = new RestTemplate();
				/*//Permet de verifier le json renvoyer par l'api
				 * ResponseEntity<String> responseEntity =
				 * template.getForEntity("https://geo.api.gouv.fr/departements/"+dto.
				 * getCodeDepartment()+"?fields=nom,code,codeRegion", String.class);
				 * System.out.println(responseEntity);
				 */
				ApiDepartmentGouvDto deptDto = template.getForObject("https://geo.api.gouv.fr/departements/"+dto.getCodeDepartment()+"?fields=nom,code,codeRegion", ApiDepartmentGouvDto.class);
				System.out.println(deptDto);
				nameDepartment = deptDto.getName();
				mapCodeNameDepartment.put(dto.getCodeDepartment(), nameDepartment);
			}
			
			response.getWriter().append(dto.getName()+";"+dto.getPopulation()+";"+dto.getCodeDepartment()+";"+ nameDepartment + ";\n");
			
			
		}
		response.flushBuffer();
	}
	
	
	
}
