package projet3_Foot;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		
		Scanner scan = new Scanner(System.in);
		
		
		
		int choix;
		do{
			
			Menu.menu();
			String choixScan = scan.nextLine();
			choix = Integer.parseInt(choixScan);
			
			switch(choix) {
			case 1:
				System.out.println("choix 1");
				break;
			case 2:
				System.out.println("choix 2");
			}
		}while(choix<1||choix>5);

}

}
