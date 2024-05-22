package fr.diginamic.chaines;

import fr.diginamic.entites.Salaire;

public class ManipulationChaine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String chaine = "Durand;Marcel;2 523.5";
		char premierCaractere = chaine.charAt(0);
		System.out.println("Premier caractère: " + premierCaractere);
		System.out.println("lenght : "+chaine.length());
		System.out.println("indexOf : "+chaine.indexOf(';'));
		System.out.println("substring : "+chaine.substring(0, chaine.indexOf(';')).toLowerCase());
		System.out.println("substring : "+chaine.substring(0, chaine.indexOf(';')).toUpperCase());
		String[] array = chaine.split(";");
		for(String c : array) {
			System.out.println("split : "+c);
		}
		Salaire salaire = new Salaire(array[0], array[1],Double.parseDouble(array[2].replaceAll(" ", "")));
		salaire.getSalaire();
	}
}
