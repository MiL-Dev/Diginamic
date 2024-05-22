package fr.diginamic.essais;

import fr.diginamic.entites.Cercle;

public class TestCercle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cercle cercle1 = new Cercle(4);
		Cercle cercle2 = new Cercle(3);
		
		System.out.println(cercle1.perimeter());
		System.out.println(cercle2.perimeter());
		System.out.println(cercle1.surface());
		System.out.println(cercle2.surface());
	}

}
