package fr.algorithmie;

import java.util.Scanner;

public class InteractifTableMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		do {
			System.out.println("Veuillez taper un nomber de 1 a 10 \n");
			number = scanner.nextInt();
		}while(number < 1 || number > 10);
		scanner.close();
		for(int i=0; i<10; i++) {
			System.out.println(number + " * " + i +" = " + number*i);
		}
	}
}
