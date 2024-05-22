package fr.diginamic.jdr;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
	int strength;
	int life;
	int score;
	
	public Character() {
		int str = ThreadLocalRandom.current().nextInt(12, 19);
		this.strength = str;
		int life = ThreadLocalRandom.current().nextInt(20, 51);
		this.life = life;
		this.score = 0;
	}
	public void AfficherScore() {
		System.out.println("Vous avez " + this.getScore() + " de score");
	}	
	public int getStrength() {
		return strength;
	}
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
