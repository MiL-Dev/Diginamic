package fr.diginamic.maison;
import java.util.Arrays;
public class Maison {
	public Piece[] arrayPiece = new Piece[0];
	
	public void ajouterPiece(Piece piece){
		
		arrayPiece = Arrays.copyOf(arrayPiece, arrayPiece.length + 1);
		arrayPiece[arrayPiece.length -1] = piece;
	}
	
	
	public double getSuperficyTotal() {
		double superficy = 0 ;
		for(Piece piece : arrayPiece) {
			superficy += piece.superficy ;
		}
		return superficy;
	}
	
	public double getSuperficyEtage(int etage) {
		double superficy = 0;
		
		for(Piece piece : this.arrayPiece) {
			if(etage == piece.etage) {
				superficy += piece.superficy;
			}
		}
		return superficy;
	}
	public double getSuperficieTotalType(String type) {
		double superficy = 0;
		for (Piece piece : this.arrayPiece) {
			if(piece.type == type) {
				superficy += piece.superficy;
			}
		}
		return superficy;
	}
	public int getTotalType(String type) {
		int total = 0;
		for (Piece piece : this.arrayPiece) {
			if(piece.type == type) {
				total +=1;
			}
		}
		return total;
	}
}
