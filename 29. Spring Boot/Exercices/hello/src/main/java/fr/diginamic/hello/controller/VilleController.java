package fr.diginamic.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.entities.Ville;
import fr.diginamic.hello.services.VilleService;

@RestController
@RequestMapping("/villes")
public class VilleController {

	@Autowired
	private VilleService serviceVille;
	
	@GetMapping
	public List<Ville> listeVille() {
		return  serviceVille.listeVille();
	}
	
	@GetMapping(path = "/villeName/{name}")
	public Ville getVille(@PathVariable String name) {
		Ville ville = serviceVille.extractByName(name);
		
		return ville;
	}
	
	@GetMapping(path = "/villeId/{id}")
	public Ville getVille(@PathVariable int id) {
		Ville ville = serviceVille.extractById(id);
		
		return ville;
	}
	
	@PostMapping
	public ResponseEntity<String> addVille(@RequestBody Ville ville) {
		if(serviceVille.extractByName(ville.getName()) != null) {
			return ResponseEntity.badRequest().body("Cette ville existe deja");
		}
		ville.setId(serviceVille.listeVille().size()+1);
		serviceVille.addVille(ville);
		return ResponseEntity.ok("L'ajout de la ville est un succes !");
	}
	
	@PutMapping(path = "/update/{id}{name}{nbHab}")
	public ResponseEntity<String> updateVille(@PathVariable int id , @RequestBody Ville ville) {
		serviceVille.updateVille(id, ville);
		return ResponseEntity.ok("La modification de la ville est un succes !");
	}
	
	@PostMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteVille(@PathVariable int id) {
		serviceVille.deleteVille(id);
		return ResponseEntity.ok("La suppression de la ville est un succes !");
	}
	
	
}
