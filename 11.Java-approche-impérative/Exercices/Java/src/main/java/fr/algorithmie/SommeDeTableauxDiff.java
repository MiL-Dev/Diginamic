package fr.algorithmie;

import java.util.Arrays;

public class SommeDeTableauxDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		int[] array2 = {-1, 12, 17, 14, 5, -9, 0, 18 };
		int[] somme = new int[3];
		for(int i=0; i < array1.length; i++) {
			somme[0] += array1[i];
			if(i < array2.length) {			
				somme[1] += array2[i];
				System.out.println(somme[1]);
			}
			
		}
		somme[2] = somme[0] + somme [1];
		System.out.println("la somme du tableau 1, tableau 2 et la somme des deux tableau : " +Arrays.toString(somme));
		
	}

}
