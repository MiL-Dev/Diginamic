package fr.diginamic.enumerations;

import org.junit.jupiter.api.Test;

public class SaisonTest {

	@Test
	public void testValueOf() {
		Saison[] saisons = Saison.values();
		
		for(Saison saison : saisons) {
			System.out.println(saison.getLibelle() + " " + saison.getOrdre());
		}
		
		
		String nom = "ETE";
		Saison ete = Saison.valueOf(nom);
		
		System.out.println(ete);
		
		String hiver = "Hiver";
		
		System.out.println(Saison.valueOfLibelle(hiver)); 
		// Le test ne fonctionnez pas avec tout sauf le premier de la liste car il y avec un else return false du coup sa arreter la boucle et ne regarder pas les autres saison du tableau.
	}

}