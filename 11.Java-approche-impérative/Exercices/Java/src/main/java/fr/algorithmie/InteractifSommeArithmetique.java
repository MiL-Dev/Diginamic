package fr.algorithmie;

import java.util.Scanner;

public class InteractifSommeArithmetique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez taper un nomber");
		int number = scanner.nextInt();
		scanner.close();
		int som = 0;
		for(int i=1; i<=number; i++) {
			som += i;
		}
		System.out.println(som);
	}
}
