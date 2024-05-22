package fr.diginamic.banque;

import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.CompteTaux;

public class TestBanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte[] account = new Compte[2];
		account[0] = new Compte(489082, 134.57);
		account[1] = new CompteTaux(245234, 243, 2);
		
		for (Compte a : account) {
			System.out.println(a.toString());
		}
	}

}
