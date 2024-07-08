package fr.diginamic.hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.hello.daos.DepartmentDao;
import fr.diginamic.hello.entities.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departDao;
	
	public void insertDepartment(Department dep) {
		
		departDao.insertDepartment(dep);
	}
	public Department extractByName(String name) {
		if(name== null) {
			return null;
		}
		return departDao.extractByName(name);
	}
}
