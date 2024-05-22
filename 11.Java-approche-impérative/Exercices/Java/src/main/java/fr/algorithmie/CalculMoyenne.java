package fr.algorithmie;

public class CalculMoyenne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4} ;
		float res = 0;
		for(int i =0; i < array.length; i++) {
			res += array[i];
		}
		res /= array.length;
		System.out.println(res);
	}

}
