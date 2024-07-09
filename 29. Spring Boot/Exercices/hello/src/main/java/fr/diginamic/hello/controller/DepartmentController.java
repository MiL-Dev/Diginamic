package fr.diginamic.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.repositories.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
}
