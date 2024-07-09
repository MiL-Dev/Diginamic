package fr.diginamic.hello.dto;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.repositories.DepartmentRepository;

public class CityDto {
	private String name;
	private String codeDepartment;
	private int population;
	
	public CityDto toDto(City city) {
		CityDto dto = new CityDto();
		dto.setName(city.getName());
		dto.setCodeDepartment(city.getDepartment().getCode());
		dto.setPopulation(city.getNbHabitants());
		return dto;
	}
	public City toBean(CityDto dto) {
		City bean = new City();
		bean.setName(dto.name);
		bean.setNbHabitants(dto.getPopulation());
		
		DepartmentRepository dR = null;
		bean.setDepartment(dR.findByCode(dto.getCodeDepartment()));
		return bean;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeDepartment() {
		return codeDepartment;
	}

	public void setCodeDepartment(String codeDepartment) {
		this.codeDepartment = codeDepartment;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}
