package fr.diginamic.hello.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.hello.entities.Ville;

@Service
public class VilleService {
	
	private List<Ville> listVille = new ArrayList<>();
	
	public VilleService() {
		Ville ville1 = new Ville("Nimes", 10000);
		Ville ville2 = new Ville("Montpellier", 32000);
		Ville ville3 = new Ville("Lyon", 52000);
		ville1.setId(1);
		ville2.setId(2);
		ville3.setId(3);
		listVille.add(ville1);
		listVille.add(ville2);
		listVille.add(ville3);
	}

	public List<Ville> listeVille() {

		return listVille;
	}
	
	public Ville extractByName(String name) {
//		Ville ville = listVille.stream().filter(v -> v.getName().equals(name));
		Ville ville = null;
		for(Ville v : this.listVille) {
			if(v.getName().equals(name)) {
				ville = v;
			}
		}
		return ville;
	}
	
	public Ville extractById(int id) {
		Ville ville = null;
		for(Ville v : this.listVille) {
			if(v.getId() == id) {
				ville = v;
			}
		}
		return ville;
	}
	public void addVille(Ville v) {
		listVille.add(v);
	}
	
	public void updateVille(int id , Ville v) {
		Ville updateVille = extractById(id);
		
		updateVille.setName(v.getName());
		updateVille.setNbHabitants(v.getNbHabitants());
		
		
	}
	public void deleteVille(int id) {
		Ville deleteVille = extractById(id);
		this.listVille.remove(deleteVille);	
	}
}
