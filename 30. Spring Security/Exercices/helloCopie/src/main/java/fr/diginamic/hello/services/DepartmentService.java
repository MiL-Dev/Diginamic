package fr.diginamic.hello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.daos.DepartmentDao;
import fr.diginamic.hello.dto.DepartmentDto;
import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departDao;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void insertDepartment(Department dep) {
		
		departDao.insertDepartment(dep);
	}
	public Department extractByName(String name) {
		if(name== null) {
			return null;
		}
		return departDao.extractByName(name);
	}
	public Department findByCode(String code) {
		Department department = departmentRepository.findByCode(code);
		DepartmentDto departmentDao = new DepartmentDto().toDto(department);
		return department;
	}
	
}
