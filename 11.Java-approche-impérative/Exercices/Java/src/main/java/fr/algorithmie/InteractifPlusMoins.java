package fr.algorithmie;

import java.util.Scanner;

public class InteractifPlusMoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nb= 11;
		int game= 0;
		
		while (game != nb) {
			System.out.println("Essai de trouver le bon nombre !");
			game = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Bravo le nombre etait bien : " + nb +  "!");
	}
}
