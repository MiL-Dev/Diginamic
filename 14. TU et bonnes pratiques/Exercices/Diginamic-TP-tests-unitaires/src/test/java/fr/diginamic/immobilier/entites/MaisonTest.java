package fr.diginamic.immobilier.entites;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaisonTest {


	@Test
	void testAjouterPiece() {
		Maison mais1 = new Maison();
		Chambre chambre = new Chambre(0, 20);
		mais1.ajouterPiece(chambre);
		assertEquals(1, mais1.nbPieces());
		mais1.ajouterPiece(null);
		assertEquals(1, mais1.nbPieces());
		
	}


	@Test
	void testSuperficieEtage() {
		Maison mais1 = new Maison();
		Chambre chambre = new Chambre(0, 20);
		mais1.ajouterPiece(chambre);
		
		assertEquals(20, mais1.superficieEtage(0));

	}

	@Test
	void testSuperficieTypePiece() {
		Maison mais1 = new Maison();
		Chambre chambre = new Chambre(0, 20);
		mais1.ajouterPiece(chambre);
		assertEquals(20, mais1.superficieTypePiece("Chambre"));
		assertEquals(20, mais1.superficieTypePiece(null));
	}

	@Test
	void testCalculerSurface() {
		Maison mais1 = new Maison();
		Chambre chambre = new Chambre(0, 20);
		mais1.ajouterPiece(chambre);
		assertEquals(20 , mais1.calculerSurface());
	}

}
