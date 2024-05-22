package fr.algorithmie;

import java.util.Scanner;

public class InteractifTantQue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nb = 0;
		do {
			System.out.println("Veuillez taper un nomber de 1 a 10 \n");
			nb = scanner.nextInt();
		}while(nb < 1 || nb > 10);
		scanner.close();
		System.out.println(nb);
	}

}
