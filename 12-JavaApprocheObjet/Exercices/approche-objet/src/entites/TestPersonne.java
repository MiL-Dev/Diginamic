package entites;

import entites2.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdressePostale a1 = new AdressePostale(10,"Impasse d'un endroit oublie",10000,"Ville");
		AdressePostale a2 = new AdressePostale(25,"impasse retrouve Modifie",40000,"Ville Modifier");
		Personne firstPerson = new Personne("Mohamed", "Bounaceur", a1);
		System.out.println(firstPerson.getName());
		System.out.println(firstPerson.getLastName());
		System.out.println(firstPerson.getAddress().city + " " + firstPerson.getAddress().streetNumber + " " + firstPerson.getAddress().streetName + " " + firstPerson.getAddress().postalCode);
		
		firstPerson.setName("prenomModifie");
		firstPerson.setLastName("nomModifie");
		firstPerson.setAdress(a2);
		
		System.out.println(firstPerson.getName());
		System.out.println(firstPerson.getLastName());
		System.out.println(firstPerson.getAddress().city + " " + firstPerson.getAddress().streetNumber + " " + firstPerson.getAddress().streetName + " " + firstPerson.getAddress().postalCode);
		//System.out.println("Le nom de la personne instancie"+firstPerson.name);
		//secondPersonn est utiliser si nous fesons l'ancienne methode.
		//Personne secondPerson = new Personne();
		//utilisation sans constructeur
		/*
		a1.streetNumber = 10;
		a1.streetName = "Adresse";
		a1.postalCode = 10000;
		a1.city = "Ville";
		*/
		//premiere methode avec la variable a1 qui permet d'etre reutilisable
		/*
		firstPerson.name = "Mohamed";
		firstPerson.lastName = "Bounaceur";
		firstPerson.Adress = a1;
		*/
		//seconde methode declarer directement l'adresse
		/*
		secondPerson.name = "Laurie-Anna";
		secondPerson.lastName = "Bounaceur";
		secondPerson.Adress.streetNumber = 16;
		secondPerson.Adress.streetName = "Rue de la gazelle";
		secondPerson.Adress.postalCode = 30000;
		secondPerson.Adress.city = "Nimes";
		*/
	}

}
