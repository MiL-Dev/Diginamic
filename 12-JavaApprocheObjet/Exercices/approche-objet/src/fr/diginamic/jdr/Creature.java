package fr.diginamic.jdr;

import java.util.concurrent.ThreadLocalRandom;

public class Creature {
	String type;
	int strength;
	int life;
	int score;
	public Creature(String type) {
		this.type = type;
		switch(type) {
		case  "wolf" :
			int wolfStr = ThreadLocalRandom.current().nextInt(3, 9);
			this.strength = wolfStr;
			
			int wolfLife = ThreadLocalRandom.current().nextInt(5, 11); //ThreadLocalRandom.current().nextInt(min, max + 1);
			this.life = wolfLife;
			this.score = 1;
			break;
		case "gobelin" :
			int gobelinStr = ThreadLocalRandom.current().nextInt(5, 11);
			this.strength = gobelinStr;
			
			int gobelinLife = ThreadLocalRandom.current().nextInt(10, 16); //ThreadLocalRandom.current().nextInt(min, max + 1);
			this.life = gobelinLife;
			this.score = 2;
			break;
		case "troll" :
			int trollStr = ThreadLocalRandom.current().nextInt(10, 16);
			this.strength = trollStr;
			
			int trollLife = ThreadLocalRandom.current().nextInt(20, 31); //ThreadLocalRandom.current().nextInt(min, max + 1);
			this.life = trollLife;
			this.score = 5;
			break;
		default: System.out.println("le type de monstre n'existe pas");
		}
	}
	public String getType() {
		return this.type;
	}
	public int getLife() {
		return life;
	}
	public int getStrength() {
		return this.strength;
	}

	public void setLife(int life) {
		this.life = life;
	}
	public int getScore() {
		return this.score;
	}
	
	
}
