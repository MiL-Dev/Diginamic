package fr.diginamic.hello.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.hello.entities.City;
@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
//	City findByName(String name);
//	City findByNameByPopulation();
	City findById(int id);
//	Recherche de toutes les villes dont le nom commence par une chaine de caractères données
	@Query("SELECT c FROM City c WHERE c.name LIKE %:name%")
	List<City> findCityByName(@Param("name") String name);
	
//	Recherche de toutes les villes dont la population est supérieure à min (paramètre de type int)
	//Premier methode :
	@Query("SELECT c FROM City c WHERE c.population > :min")
	List<City> findCityByPopulationMin(@Param("min") int min);
	
	//Deuxieme methode 
	List<City> findByPopulationGreaterThan(int min);
//	Recherche de toutes les villes dont la population est supérieure à min et inférieure à max.
	List<City> findByPopulationBetween (int min, int max);
//	Recherche de toutes les villes d’un département dont la population est supérieure à min (paramètre de type int)
	List<City> findByPopulationGreaterThanAndDepartmentCode(int min, String code );
//	Recherche de toutes les villes d’un département dont la population est supérieure à min et inférieure à max.
	List<City> findByPopulationBetweenAndDepartmentCode(int min, int max, String code);
//	Recherche des n villes les plus peuplées d’un département donné (n est aussi un paramètre)
	List<City> findAllByDepartmentCodeOrderByPopulationDesc(String code, Pageable page);
}

