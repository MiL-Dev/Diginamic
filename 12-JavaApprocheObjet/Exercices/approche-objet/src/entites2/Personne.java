package entites2;

import entites.AdressePostale;

public class Personne {
	private String name;
	private String lastName;
	private AdressePostale address;
	
	public Personne( String na,String lastN, AdressePostale addr) {
		name = na;
		lastName = lastN;
		address = addr;
	}
	public void setName(String n) {
		name = n;
	}
	public void setLastName(String lN) {
		lastName = lN;
	}
	public void setAdress(AdressePostale addr) {
		address = addr;
	}
	public String getName() {
		return name;
		}
	public String getLastName() {
		return lastName.toUpperCase();
	}
	public AdressePostale getAddress() {
		return address;
		
	}
}
