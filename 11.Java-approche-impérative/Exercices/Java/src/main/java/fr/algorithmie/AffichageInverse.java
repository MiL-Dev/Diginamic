package fr.algorithmie;

import java.util.Arrays;

public class AffichageInverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		System.out.println(" --------------- \n");
		for(int i=0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("\n --------------- \n");

		for(int i=array.length-1; i >= 0; i--) {
			System.out.println(array[i]);
		}
		System.out.println("\n --------------- \n");
		
		int [] arrayCopy = new int[array.length];
		for(int i = 0; i< arrayCopy.length; i++) {
			arrayCopy[i] = array[i];
		}
		System.out.println("arrayCopy : " + Arrays.toString(arrayCopy));
	}
	
}
