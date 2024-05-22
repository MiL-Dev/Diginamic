package fr.algorithmie;

import java.util.Arrays;

public class Rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,1,2,3};
		int[] arrayRes = new int[array.length];
		arrayRes[0] = array[array.length-1];;
		for(int i=1; i<array.length; i++) {
			arrayRes[i] = array[i-1];
		}
		System.out.println(Arrays.toString(arrayRes));
	}

}
