package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {

	public static void main(String[] args) {
		Maison maison = new Maison();
		Piece chambre1 = new Chambre(12, 1); // test message nombre negatif
		Piece chambre2 = new Chambre(11, 1);
		Piece chambre3 = new Chambre(17, 2);
		//Piece chambre3 = new Chambre(null, -1); On ne peu pas ajouter quelque chose de null, mais on peu faire des nombres negatif
		Piece salleDeBainC = new SalleDeBain(20, 2);
		Piece cuisine = new Cuisine(30, 0);
		Piece salon = new Salon(40, 0);
		Piece salleDeBain = new SalleDeBain(15, 0);
		Piece wc = new WC(3, 0);
		
		maison.ajouterPiece(chambre1);
		maison.ajouterPiece(chambre2);
		maison.ajouterPiece(chambre3);
		//maison.ajouterPiece(chambre3);
		maison.ajouterPiece(salleDeBainC);
		maison.ajouterPiece(cuisine);
		maison.ajouterPiece(salon);
		maison.ajouterPiece(salleDeBain);
		maison.ajouterPiece(wc);
		
		System.out.println(maison.getSuperficyTotal());
		System.out.println(maison.getSuperficyEtage(0));
		System.out.println(maison.getSuperficyEtage(1));
		System.out.println(maison.getSuperficyEtage(2));
		System.out.println(maison.getSuperficieTotalType("Chambre")); // toutes les chambres de la maison
		System.out.println(maison.getTotalType("SalleDeBain")); //Chambre - Salon - Cuisine - WC - SalledeBain
	}

}
