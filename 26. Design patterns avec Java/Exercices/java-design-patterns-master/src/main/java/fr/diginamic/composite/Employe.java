package fr.diginamic.composite;

public class Employe implements IElement {
	String nom;
	String prenom;
	double salaire;
	
	public Employe(String nom, String prenom, double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}

	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		return salaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

}
