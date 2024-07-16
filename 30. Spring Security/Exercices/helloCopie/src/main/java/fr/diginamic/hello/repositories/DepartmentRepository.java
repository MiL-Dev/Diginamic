package fr.diginamic.hello.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.hello.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	Department findById(int id);
	Department findByCode(String code);
}
