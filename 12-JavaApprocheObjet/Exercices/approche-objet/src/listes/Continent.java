package listes;

public enum Continent {
	EUROPE("Europe"),
	AFRIQUE("Afrique"),
	ASIE("Asie"),
	AMERIQUE("Amerique"),
	OCEANIE("Oceanie");
	
	private String name;
	
	private Continent(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	
}
