package fr.tableaux;

public class ExerciceDeclarationTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tab = new int[8];
		tab[0]= 8;
		tab[1]= -7;
		tab[2]= 12;
		tab[3]= 1;
		tab[4]= -2;
		tab[5]= 14;
		tab[6]= 17;
		tab[7]= 9;
		//tab[10]= 9; cela echou car l'index demander n'existe pas
		String exo1 = "Exercice 1 resultat : " + tab[0] + tab.length + tab[tab.length-1];
		System.out.println(exo1);
	}

}
