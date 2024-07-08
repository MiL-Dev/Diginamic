package fr.diginamic.hello.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.hello.entities.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class DepartmentDao {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertDepartment(Department dep) {
		em.persist(dep);
	}
	
	public Department extractByName(String name) {
		TypedQuery<Department> query = em.createQuery("SELECT c FROM City c WHERE c.name=:name", Department.class);
		query.setParameter("name", name);
		List<Department> listCities = query.getResultList();
		if(listCities.size() > 0) {
			return listCities.get(0);
		}
		return null;
	}
}
