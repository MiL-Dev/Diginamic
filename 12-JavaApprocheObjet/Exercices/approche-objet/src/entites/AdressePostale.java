package entites;

public class AdressePostale {
	
	public int streetNumber;
	public String streetName;
	public int postalCode;
	public String city;
	
	public AdressePostale(int streetN, String streetNa, int postalC,String city) {
		
		streetNumber = streetN; // ici sans this car les parametre et la nom de cette variable ne sont pas pareil
		streetName = streetNa;
		postalCode = postalC;
		this.city = city; //Ici ont a besoin de this car le nom de la variable est pareil
		//System.out.println("Numero de rue direct depuis la classe mais qui appartient a l'instance de cette classe : "+this.streetNumber);
	}
}
