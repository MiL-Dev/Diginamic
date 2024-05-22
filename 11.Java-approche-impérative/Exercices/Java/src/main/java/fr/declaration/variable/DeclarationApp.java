package fr.declaration.variable;

public class DeclarationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 0145; //0 permet de passer en octale : 5 + 4*8 + 1*8*8
		short b = -15325;
		int b2 = 3;
		long c = 10000L;
		float d = 1.8F;
		double e = 1.8;
		char f = '\uabcd'; //simple quote (') unicode 
		boolean g = true;
		String h = "Salut";
		System.out.println(a); //syso + CTRL Espace
		System.out.println(b);
		System.out.println(b2);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		String randomString = "Voici le résultat d’un calcul : \n 1+5=6";
		System.out.println(randomString);
	}

}
