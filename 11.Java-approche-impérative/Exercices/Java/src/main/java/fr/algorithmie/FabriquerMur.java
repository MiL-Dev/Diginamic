package fr.algorithmie;

public class FabriquerMur {

	public static void main(String[] args) {
		// Tests de verififaction
		verifier(3, 1, 8, true);
		verifier(3, 2, 10, true);
		verifier(3, 2, 8, true);
		verifier(3, 2, 9, true);
		verifier(6, 1, 11, true);
		verifier(6, 0, 11, false);
		verifier(1, 4, 11, true);
		verifier(0, 3, 10, true);
		verifier(1, 4, 12, true);
		verifier(3, 1, 7, true);
		verifier(1, 1, 7, false);
		//Je n'ai pas compris cette methode verifier pourquoi elle met true quand le mur ne peu pas etre construit et l'inverse quand il peu.
		
	}
	public static boolean fabriquerMur(int nbSmall, int nbBig, int longueur) {
		nbBig *= 5;
		if(nbSmall + nbBig >= longueur) {
			return true;
		}
		return false;
	}
	private static void verifier(int nbSmall, int nbBig, int longueur, boolean b) {
		if (!fabriquerMur(nbSmall, nbBig, longueur) == b) {
			System.err.println("Test (" + nbSmall + ", " + nbBig + ", " + longueur + ") NON passant.");
		}
	}
}
