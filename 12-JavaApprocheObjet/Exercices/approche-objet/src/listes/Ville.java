package listes;

import java.util.Objects;
/** Représente le concept de Ville dans l'application de recensement.
* Une Ville possède 3 propriétés principales :
* - un nom
* - un nombre d'habitants
* - un Continent
* @author MohamedBOUNACEUR
* @version 1.0
*/
public class Ville {
	/** name */
	private String name;
	/** nbHab */
	private int nbHab;
	private String continent;
	
	
	/** Constructor
	 * @param name
	 * @param nbHab
	 * @param continent
	 */
	public Ville(String name, int nbHab, Continent continent) {
		super();
		this.name = name;
		this.nbHab = nbHab;
		this.continent = continent.getName();
	}
	
	
	@Override
	public String toString() {
		return "Ville : " + name + "\nNombre d'habitant : " + nbHab + "\ncontinent : " + continent + "\n-------";
	}

	@Override
	public boolean equals(Object object) {
		//Si l'argument envoyer(object) n'est pas un une instance de type Ville return false
		if(!(object instanceof Ville other)) { 
			return false;
		}
		
		//return this.name.equals(other.getName()) && this.nbHab==other.getNbHab();
		return Objects.equals(this.name, other.getName()) && Objects.equals(this.nbHab, other.getNbHab());
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

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
}
