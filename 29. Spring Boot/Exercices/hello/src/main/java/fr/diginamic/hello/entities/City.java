package fr.diginamic.hello.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Le nom de la ville doit etre renseigne")
	@Size(min=1)
	private String name;
	
	private int population;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_department")
	private Department department;
	
	public City(String name, int nbHabitants, Department department) {
		super();
		this.name = name;
		this.population = nbHabitants;
		this.department = department;
	}
	public City() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(name, other.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbHabitants() {
		return population;
	}
	public void setNbHabitants(int nbHabitants) {
		this.population = nbHabitants;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
