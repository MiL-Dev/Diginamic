package fr.diginamic.numeration;

public enum Saison {
	
	PRINTEMPS("Printemps",1),
	ETE("Ete",2),
	AUTOMNE("Automne",3),
	HIVER("Hiver",4);
	
	private int order;
	private String name;
	
	private Saison(String name, int order) {
		this.name = name;
		this.order = order;
	}
	
	public static Saison getSaison(String libelle) {
		Saison[] trySaison = Saison.values();
		for (Saison saison : trySaison) {
			if(saison.getName() == libelle) {
				return saison;
			}
		}
		return null;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
