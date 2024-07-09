package fr.diginamic.hello.dto;

import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.entities.Department;

public class DepartmentDto {
	private String codeDepartment;
	private int totalPopulation;
	
	public DepartmentDto toDto(Department department) {
		DepartmentDto dto = new DepartmentDto();
		dto.setCodeDepartment(department.getCode());
		
		for(City city : department.getCities()) {
			totalPopulation +=city.getNbHabitants();
		}
		dto.setTotalPopulation(totalPopulation);
		
		return dto;
	}
	
	public Department toBean(DepartmentDto dto) {
		Department bean = new Department();
		bean.setCode(codeDepartment);
		return bean;
	}
	
	public String getCodeDepartment() {
		return codeDepartment;
	}

	public void setCodeDepartment(String codeDepartment) {
		this.codeDepartment = codeDepartment;
	}

	public int getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(int totalPopulation) {
		this.totalPopulation = totalPopulation;
	}
}
