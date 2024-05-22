package maps;

public class Pays {
	String name;
	int population;
	String mainland;
	
	public Pays(String name, int population, String mainland) {
		super();
		this.name = name;
		this.population = population;
		this.mainland = mainland;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getMainland() {
		return mainland;
	}
	public void setMainland(String mainland) {
		this.mainland = mainland;
	}
	
	
}
