package fr.diginamic.jdr;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] typeMonster = {"","wolf", "gobelin","troll"};
		Character character = new Character();
		System.out.println("Bienvenue dans le JDR de MiL !\n");
		System.out.println("Votre personnage a " + character.getStrength()+ " de force\nPoint de vie "+ character.getLife());
		
		int scan = 0;
		while(scan != 5) {

			System.out.println("\nMenu\n1.Combattre contre un loup\n2.Combattre contre un gobelin\n3.Combattre contre un troll\n\n5.Arreter le jeu et afficher le score.");
			do {
				try {
					scan = scanner.nextInt();
				}catch(Exception  e){
					scanner.next();
					System.out.println("Veuillez tape le nombre indiquer sur le menu ");
				}
				if(scan < 1 || scan > 6) {
					System.out.println("Veuillez mettre un nombre qui est dans le menu");
				}
			}while(scan < 1 || scan > 6);
			
			if(scan == 5) {
				character.AfficherScore();
				System.out.println("Partie Terminer !");
				return;
			}
			Creature monster = new Creature(typeMonster[scan]);
			
			System.out.println("Le combat va commencer ! Au ARMMEEE !! \n" );
			System.out.println("Caracteristique du monstre choisie :\n " + monster.getStrength()+ " de force\nPoint de vie "+ monster.getLife());
			
			int attackPowerCharacter = 0; 
			int attackPowerMonster = 0;
			int damage = 0;
			while(monster.getLife() > 0 && character.getLife() > 0) {
				attackPowerCharacter = ThreadLocalRandom.current().nextInt(1, 11) + character.getStrength();
				attackPowerMonster = ThreadLocalRandom.current().nextInt(1, 11) + monster.getStrength();
				
				if(attackPowerCharacter == attackPowerMonster) {
					System.out.println("Vous taper a egaliter personne ne perd de point de vie");
				}else if(attackPowerCharacter > attackPowerMonster) {
					damage = attackPowerCharacter -  attackPowerMonster;
					System.out.println("\nVous frapper plus fort que le monstre, vous infliger : "+damage+" de degats");
					monster.setLife(monster.getLife()-damage);
				}else {
					damage = attackPowerMonster - attackPowerCharacter;
					System.out.println("Le monstre vous fracasse, il vous inflige : "+damage+" de degats\n");
					character.setLife(character.getLife()-damage);
				}
			}
			if(monster.getLife() < 1) {
				System.out.println("\nBravo vous avez combattue le monstre et vous remporter " + monster.getScore()+" point de score");
				character.setScore(character.getScore() + monster.getScore());
				System.out.println("Il vous reste" + character.getLife() + " point de vie");
			}else {
				System.out.println("Vous avez perdu tout vos points de vie\nPartie terminer");
				character.AfficherScore();
				scan = 5;
				scanner.close();
			}
		}
	}

}
