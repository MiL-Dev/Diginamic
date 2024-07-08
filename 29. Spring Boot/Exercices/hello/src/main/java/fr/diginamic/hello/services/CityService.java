package fr.diginamic.hello.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.daos.CityDao;
import fr.diginamic.hello.entities.City;

@Service
public class CityService {
	
	private List<City> cities;

	@Autowired
	private CityDao cityDao;
	
	public List<City> extractAllCity() {

		return cityDao.extractAllCities();
	}
	
	public City extractByName(String name) {
		
//		Ville villeFind = listVille.stream().filter(v -> v.getName().equals(name)).findFirst().orElse(null);
//		if(villeFind!=null) {
//			return villeFind;
//		}
//		Ville ville = null;
//		for(Ville v : this.listVille) {
//			if(v.getName().equals(name)) {
//				ville = v;
//			}
//		}
		if(name == null) {
			return null;
		}
		return cityDao.extractByName(name);
	}
	
	public City extractById(int id) {
		
		if(id == 0) {
			return null;
		}
		return cityDao.extractById(id);
	}
	public void addVille(City v) {
		cityDao.insertCity(v);
	}
	
	public void updateCity(int id, City city) {
		City cityOld = cityDao.extractById(id);
		cityOld.setName(city.getName());
		cityOld.setNbHabitants(city.getNbHabitants());
		cityDao.updateCity(cityOld);		
	}
	public void deleteVille(int id) {
		City deleteVille = extractById(id);
		this.cities.remove(deleteVille);	
	}
}
