package fr.diginamic.maison;

public abstract class Piece extends Maison{
	double superficy;
	int etage;
	String type;
	public Piece(double superficy, int etage, String type) {
		if (superficy <= 0) {
			System.out.println("Vous ne pouvez pas ajouter une piece avec une superficie negative ou egale a 0 ");
		}else {
			this.superficy = superficy;
		}
		this.etage = etage;
		this.type = type;
	}
	
}	
