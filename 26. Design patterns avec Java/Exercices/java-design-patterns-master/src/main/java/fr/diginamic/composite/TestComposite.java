package fr.diginamic.composite;

public class TestComposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employe directeur = new Employe("Cecile", "RASPEY", 10000);
		Employe architecte = new Employe("Bilel", "BECHKAR", 8000);
		
		Employe chefJava = new Employe("Kevin", "GUINEAU", 7500);
		
		Employe chefData = new Employe("Jb", "RANMEY", 7500);
		
		
		
		
		Service javaDev = new Service("Java Dev", chefJava);
		
		Service bigData = new Service("Big Data", chefData);
		
		Service dsin = new Service("DSIN", directeur,architecte, javaDev, bigData);
		
		
		System.out.println(dsin.calculerSalaire());
		System.out.println(javaDev.calculerSalaire());
	}
}
