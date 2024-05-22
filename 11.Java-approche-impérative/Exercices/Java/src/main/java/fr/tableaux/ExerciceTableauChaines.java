package fr.tableaux;

public class ExerciceTableauChaines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] exo2 = new String[5];
		exo2[0] = "Nimes";
		exo2[1] = "Montpellier";
		exo2[2] = "Marseille";
		exo2[3] = "Avignon";
		exo2[4] = "Paris";
		
		String resultatExo2 = "Resultat exercice 2 : " + exo2[0] + " " + exo2[1] + " " + exo2[2] + " " + exo2[3] + " " + exo2[4]+ "\n. Et la taille du tableau " + exo2.length;
		System.out.println(resultatExo2);
		exo2[3] = "Reims";
		resultatExo2 = "Resultat suite exercice 2 : " + exo2[0] + " " + exo2[1] + " " + exo2[2] + " " + exo2[3] + " " + exo2[4]+ "\n. Et la taille du tableau " + exo2.length;
		System.out.println(resultatExo2);
	}

}
