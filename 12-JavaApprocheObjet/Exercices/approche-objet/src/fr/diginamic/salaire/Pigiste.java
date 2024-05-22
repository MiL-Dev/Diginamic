package fr.diginamic.salaire;


public class Pigiste extends Salaire {

	int dayWorks;
	double salaryPerDay;
	public Pigiste(String lastName, String name, double salaryDay , double dayWorks, String status) {
		super(lastName, name, ( salaryDay * dayWorks), status);
		salaryPerDay = salaryDay;
	}
	public double getSalaire() {
		return salaryPerDay;
	}
	public void afficherDonnees() {
		System.out.println("\nNom : " +super.lastName +"\nPrenom : " + super.name +"\nMois : " + super.salaryMonth + " Jour : " +this.salaryPerDay +"\nStatus : " + this.status);
	}

}
