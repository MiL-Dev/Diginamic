package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theatre theatre1 = new Theatre("Theatre 1", 20);
		
		theatre1.registration(5, 20);
		theatre1.registration(14, 20);
		theatre1.registration(2, 20);
		
		System.out.println("Client inscrit : " +theatre1.getClientsTotal() + "\nRecette total : " + theatre1.getRecipeTotal() + "$");
	}
}
