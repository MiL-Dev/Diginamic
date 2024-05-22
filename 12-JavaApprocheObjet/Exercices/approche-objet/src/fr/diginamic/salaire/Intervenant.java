package fr.diginamic.salaire;

public abstract class Intervenant {
	String lastName;
	String name;
	
	public Intervenant(String lastName, String name) {
		this.lastName = lastName;
		this.name = name;
	}

	public abstract double getSalaire();
	
	public void afficherDonnees() {
		System.out.println("\nNom :" + this.lastName + "\nPrenom :" + this.name );
	}
}
