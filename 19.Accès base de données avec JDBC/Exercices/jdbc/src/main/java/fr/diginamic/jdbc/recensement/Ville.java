package fr.diginamic.jdbc.recensement;

public class Ville {
	int id;
	String nom;
	int population;
	int idDept;
	int idRegion;
	
	public Ville(int id, String nom, int population, int idDept, int idRegion) {
		super();
		this.id = id;
		this.nom = nom;
		this.population = population;
		this.idDept = idDept;
		this.idRegion = idRegion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getIdDept() {
		return idDept;
	}

	public void setIdDept(int idDept) {
		this.idDept = idDept;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
}
