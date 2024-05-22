package tri;

public class Ville implements Comparable<Ville> {
	private String name;
	private int nbHab;
	
	public Ville(String name, int nbHab) {
		super();
		this.name = name;
		this.nbHab = nbHab;
	}
	@Override
	public int compareTo(Ville o) {
		// TODO Auto-generated method stub
		//return -name.compareTo(o.getName()); //Tri en ordre alphabetique
		
		
		//return pas nombre d'habitant
		if(nbHab > o.getNbHab()) {
			return 1;
		}else if(nbHab < o.getNbHab()) {
			return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Ville [name=" + name + ", nbHab=" + nbHab + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbHab() {
		return nbHab;
	}
	public void setNbHab(int nbHab) {
		this.nbHab = nbHab;
	}
	
	
}
