package entites;

public class TestAdressePostale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdressePostale firstAdress = new AdressePostale(16,"Rue de la gazelle",30000,"Nimes");
		firstAdress.streetNumber = 16;
		firstAdress.streetName = "Rue de la gazelle";
		firstAdress.postalCode = 30000;
		firstAdress.city = "Nimes";
		
		//Ancienne methode sans constructeur
		/*
		AdressePostale secondAdress = new AdressePostale();
		secondAdress.streetNumber = 30;
		secondAdress.streetName = "Rue de la inconnu";
		secondAdress.postalCode = 23030;
		secondAdress.city = "Reveur";
		*/
	}

}
