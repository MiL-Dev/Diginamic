package fr.algorithmie;

import java.util.Arrays;

public class InversionContenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		int[] arrayCopy = new int[array.length];
		
		for(int i = arrayCopy.length-1, y =0; i >= 0 ; i-- , y++) {
			arrayCopy[y] = array[i];
		}
		System.out.println("array : "+ Arrays.toString(array));
		System.out.println("arrayCopy : "+ Arrays.toString(arrayCopy));
	}

}
