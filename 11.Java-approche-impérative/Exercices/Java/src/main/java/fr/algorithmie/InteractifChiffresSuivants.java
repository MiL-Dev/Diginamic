package fr.algorithmie;

import java.util.Scanner;

public class InteractifChiffresSuivants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez taper un nomber");
		int number = scanner.nextInt();
		scanner.close();
		for(int i=number+1; i<number+11; i++) {
			System.out.println(i);
		}
		
	}

}
