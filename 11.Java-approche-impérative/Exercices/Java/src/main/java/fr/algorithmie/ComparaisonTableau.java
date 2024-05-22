package fr.algorithmie;

public class ComparaisonTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 15, -3, 8, 7, 4, -2, 28, -1, 17, 2, 3, 0, 14, -4};
		int[] array2 = {3, -8, 17, 5, -1, 4, 0, 6, 2, 11, -5, -4, 8};
		for(int i=0; i< array1.length; i++) {
			for(int y=0; y< array2.length; y++) {
				if(array1[i] == array2[y]) {
					System.out.println("Ce nombre est en commun les deux tableaux " +array1[i]);
				}
			}
		}
	}

}
