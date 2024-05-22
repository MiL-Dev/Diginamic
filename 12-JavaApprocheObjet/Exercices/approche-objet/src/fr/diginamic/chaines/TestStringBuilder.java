package fr.diginamic.chaines;

import utils.StringUtils;

public class TestStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder builderNumber = new StringBuilder(); //Declaration = 1ms
		//String stringNumber = String.format("J'ai %d", 0); //Declaration = 35ms
		long debut = System.currentTimeMillis();
		
		
		for(int i=0; i<100000; i++) {
			//builder	
			builderNumber.append(i).append(" "); // 6ms
			//stringNumber = stringNumber + i; // 2800ms
			//stringNumber = stringNumber.concat(Integer.toString(i)); // 2800ms
			//stringNumber = String.format("J'ai %d", i); // 142ms
		}
		//builderNumber.toString();
		// Code à chronométrer
	
		long fin = System.currentTimeMillis();
	
		System.out.println("Temps écoulé en millisecondes :" + (fin - debut));
		System.out.println("\n");
		//System.out.println(builderNumber);
		System.out.println(StringUtils.sBuilder("Test de la methode static", " on peu y mettre n'importe quel type par ce que en parametre est de type Object"));
		}

}