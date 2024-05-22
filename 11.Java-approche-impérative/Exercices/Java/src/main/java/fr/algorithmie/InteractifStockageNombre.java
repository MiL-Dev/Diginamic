package fr.algorithmie;

import java.util.Arrays;
import java.util.Scanner;

public class InteractifStockageNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[0];
		int option = 0;
		System.out.println("1. Ajouter un nombre\r\n"
				+ "2. Afficher les nombres existants.");
		Scanner scanner = new Scanner(System.in);
		
		while(option != 2) {
			do {
				System.out.println("Choisie l'option en saisisant le 1 ou 2");
				option = scanner.nextInt();
			}while(option != 1 && option != 2);
			if(option == 1 ) {
				System.out.println("Veuillez Taper un nombre a sauvegarder");
				array = Arrays.copyOf(array,array.length +1);
				array[array.length - 1] = scanner.nextInt();
			}	
		}
		System.out.println("Voici le(s) nombres que vous avez sauvegarder : " + Arrays.toString(array));
		scanner.close();
	}

}
