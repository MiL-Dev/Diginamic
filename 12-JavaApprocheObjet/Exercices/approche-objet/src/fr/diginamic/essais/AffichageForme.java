package fr.diginamic.essais;

import fr.diginamic.formes.Forme;

public class AffichageForme {

	public static void afficher(Forme forme) {
		System.out.println("Perimetre : "+ Double.toString(forme.perimeter()));
		System.out.println("Surface : "+ Double.toString(forme.surface()));
	}

}
