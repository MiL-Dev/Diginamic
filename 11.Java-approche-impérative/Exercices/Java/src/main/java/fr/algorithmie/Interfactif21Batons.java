package fr.algorithmie;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
public class Interfactif21Batons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenue dans le jeu des 21 Baton\n La regles est simple il y a 21 baton, celui qui prend le derniers baton a perdu.\n Vous pouvez prendre entre 1 et 4 baton a la fois.");
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> section = new ArrayList<Integer>();
		for(int i =0; i<21; i++) {
			section.add(i);
		}
		int scan = 0;
		int range = 4 - 1 +1;
		
		
		while(section.size() > 0) {
			int rand = (int)(Math.random() * range) + 1;
			
			do {
				System.out.println("Veuillez taper un nombre entre 1 et 4");
				try {
					scan = scanner.nextInt();
				}catch(Exception  e){
					scanner.next();
					System.out.println("Veuillez mettre un nombre svp ");
				}
				
			}while(scan < 1 || scan > 4);
			if(section.size() <= 1) {
				System.out.println("Vous avez Perdu ! Vous avez essayer de retirer : " + rand + " baton alors qu'il en rester : " + section.size());
				break;
			}else {
				for(int i=scan; i>0; i--) {
					section.remove(section.size()-1);
				}
				System.out.println("vous retirez "+scan+" baton(s)\n");
				
			}if(section.size() == 0) {
				System.out.println("Vous avez Perdu ! Vous avez essayer de retirer : " + rand + " baton alors qu'il en rester : " + section.size());
				break;
			}
			if(section.size() < rand ) {
				System.out.println("Vous avez gagne ! 'IA a essayer de retirer : " + rand + " baton alors qu'il en rester : " + section.size());
				break;
			}else {
				for(int i=rand; i>0; i--) {
					section.remove(section.size()-1);
				}
				System.out.println("Au tour de l'ordinateur\n");
				System.out.println("Il retire "+rand+" baton(s)\n");
				System.out.println("Continuer il reste "+section.size()+" baton(s)\n");
			}

		}
		scanner.close();
	}

}
