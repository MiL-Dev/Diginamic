package fr.diginamic.essais;

import fr.diginamic.salaire.*;

public class TestIntervenant {

	public static void main(String[] args) {
		Salaire salary = new Salaire("Bounaceur", "Mohamed", 5600, "CDI");
		Salaire freelancer = new Pigiste("Montmiralle", "Patrick", 120, 10, "Independant");
		
		System.out.println("getSalaire : " + salary.getSalaire());
		System.out.println("getSalaire : " + freelancer.getSalaire());
		
		salary.afficherDonnees();
		freelancer.afficherDonnees();
	}

}
