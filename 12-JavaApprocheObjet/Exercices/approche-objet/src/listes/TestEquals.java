package listes;

public class TestEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ville v1 = new Ville("Nice", 5000, Continent.EUROPE);//ajout du continent#Enum
		Ville v2 = new Ville("Nice", 5000,Continent.EUROPE);
		
		
		System.out.println(v1.equals(v2));
		System.out.println(v1 == v2);
		
		
		//resultat true equal
		//resultat false pour ==
		
		//si on change d'attribue les deux sont false
		
		//verifier directement le contenu des variables de classe
		System.out.println(v1.getName() == v2.getName());
		
	}

}
