package fr.algorithmie;

import java.util.Scanner;

public class InteractifPlusGrand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez taper un nomber");
		int number= 0;
		for(int i = 0; i<10; i++) {
			int scan = scanner.nextInt();
			if(number < scan) {
				number = scan;
				System.out.println(number);
			}
		}
		scanner.close();
		System.out.println("Le nombe le plus grand est :"+number);
	}

}
