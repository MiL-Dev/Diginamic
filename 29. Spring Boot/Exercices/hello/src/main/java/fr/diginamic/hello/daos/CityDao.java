package fr.diginamic.hello.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.hello.entities.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CityDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertCity(City v) {
		em.persist(v);
	}
	
	@Transactional
	public List<City> extractAllCities(){
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c", City.class);
		return query.getResultList();
	}
	@Transactional
	public City extractByName(String name) {
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:name", City.class);
		query.setParameter("name", name);
		List<City> listCities = query.getResultList();
		if(listCities.size() > 0) {
			return listCities.get(0);
		}
		return null;
	}
	@Transactional
	public City extractById(int id) {
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.id=:id", City.class);
		query.setParameter("id", id);
		List<City> listCities = query.getResultList();
		if(listCities.size() > 0) {
			return listCities.get(0);
		}
		return null;
	}
	@Transactional
	public void updateCity(City c) {
		em.persist(c);
	}
}
