package fichier;


public class Ville  {
	String name;
	String departement;
	String nameRegion;
	int populationTotal;
	
	public Ville(String name, String departement, String nameRegion, int populationTotal) {
		super();
		this.name = name;
		this.departement = departement;
		this.nameRegion = nameRegion;
		this.populationTotal = populationTotal;
	}
	
	@Override
	public String toString() {
		return "Ville [name=" + name + ", nbHab=" + populationTotal + "]";
	}
	public String toCsv() {
		return nameRegion+";"+departement+";"+name+";"+populationTotal;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getNameRegion() {
		return nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		this.nameRegion = nameRegion;
	}

	public int getPopulationTotal() {
		return populationTotal;
	}

	public void setPopulationTotal(int populationTotal) {
		this.populationTotal = populationTotal;
	}
	
}
