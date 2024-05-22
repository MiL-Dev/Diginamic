package fr.diginamic.salaire;

public class Salaire extends Intervenant {
	double salaryMonth;
	String status;
	
	public Salaire(String lastName, String name, double salaryMonth, String status) {
		super(lastName, name);
		this.salaryMonth = salaryMonth;
		this.status = status;
	}
	public double getSalaire() {
		return this.salaryMonth;
	}
	public void afficherDonnees() {
		System.out.println("\nNom : " +super.lastName +"\nPrenom : " + super.name +"\nMois : " + this.salaryMonth +"\nStatus : " + this.status);
	}
}
