package fr.diginamic.hello.entities;

public class Ville {
	private int id;
	private String name;
	private int nbHabitants;
	
	public Ville(String name, int nbHabitants) {
		super();
		this.name = name;
		this.nbHabitants = nbHabitants;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbHabitants() {
		return nbHabitants;
	}
	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
