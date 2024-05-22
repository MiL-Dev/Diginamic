package fr.diginamic.entites;

public class Theatre {
	String name;
	int capacityMax;
	int clientsTotal;
	int recipeTotal;
	
	public Theatre (String name, int capacityMax) {
		this.name = name;
		this.capacityMax = capacityMax;
	}
	
	public void registration(int place, int priceBase) {
		if(capacityMax >= clientsTotal + place) {
			clientsTotal += place;
			recipeTotal = priceBase * clientsTotal;
		}else {
			System.out.println("La demande d'enrechistrement de "+ place +" place(s) a echoue car il reste actuellement "+ (capacityMax - clientsTotal) + " place(s)...");
		}
		
	}
	public int getClientsTotal() {
		return clientsTotal;
	}

	public int getRecipeTotal() {
		return recipeTotal;
	}

	
	
}
