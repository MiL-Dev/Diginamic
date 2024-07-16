package fr.diginamic.hello.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.daos.CityDao;
import fr.diginamic.hello.dto.CityDto;
import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.repositories.CityRepository;
import fr.diginamic.hello.repositories.DepartmentRepository;

@Service
public class CityService {

	@Autowired
	private CityDao cityDao;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private DepartmentRepository departmentRepository;
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
			System.out.println("id = null");
			return null;
		}
		return cityDao.extractById(id);
	}
	public void addVille(City c) {
		Department department = departmentRepository.findByCode(c.getDepartment().getCode());
		
		if(c.getDepartment().getCode().equals(department.getCode())) {
			c.setDepartment(department);
		}
		System.out.println("ajout dans la base de donnee");
		cityDao.insertCity(c);
	}
	
	public void updateCity(int id, City city) {
		City cityOld = cityDao.extractById(id);
		cityOld.setName(city.getName());
		cityOld.setPopulation(city.getPopulation());
		cityDao.updateCity(cityOld);		
	}
	public boolean deleteVille(int id) {
		City deleteVille = extractById(id);
		if(deleteVille !=null) {
			cityDao.remove(deleteVille);
			return true;
		}
		return false;
	}
	
	public List<CityDto> allCities() {
		
		List<City> cities = cityDao.extractAllCities();
		List<CityDto> citiesDto = new ArrayList<>();
		for(City c : cities) {
			CityDto cDto = new CityDto();
			cDto.toDto(c);
			citiesDto.add(cDto);
		}
		return citiesDto;
	}

	public List<CityDto> findByNbHabsMin(int min) {
		List<City> cities = cityRepo.findCityByPopulationMin(min);
		List<CityDto> citiesDto = new ArrayList<>();
		for(City c : cities) {
			CityDto cityDto = new CityDto().toDto(c);
			citiesDto.add(cityDto);
		}
		return citiesDto;
	}

	public Object findAllByDepartmentCodeOrderByPopulationDesc(String code, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByPopulationBetweenAndDepartmentCode(int min, int max, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findByPopulationGreaterThanAndDepartmentCode(int min, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> findByPopulationBetween(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> findByPopulationGreaterThan(int min) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> findCityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
