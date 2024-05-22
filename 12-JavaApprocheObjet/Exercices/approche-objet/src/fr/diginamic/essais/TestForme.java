package fr.diginamic.essais;

import fr.diginamic.formes.*;

public class TestForme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cercle cercle = new Cercle(5);
		Rectangle rectangle = new Rectangle(3, 2);
		Carre carre = new Carre(4);
		
		System.out.println("Le cercle " );
		AffichageForme.afficher(cercle);
		System.out.println("\nLe rectangle " );
		AffichageForme.afficher(rectangle);
		System.out.println("\nLe carre " );
		AffichageForme.afficher(carre);
	}

}
