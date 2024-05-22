package fr.algorithmie;

public class AffichagePartiel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 15, -3, 0, 8, 7, 4, -2, 28, 7, -1, 17, 2, 3, 0, 14, -4};
		System.out.println("Nombres superieur 3 \n");
		for(int i = 0; i < array.length; i++) {
			if(array[i] > 3) {
				System.out.println(array[i]);
			}
		}
		System.out.println("\n Nombres pairs \n");
		for(int i = 0; i < array.length; i++) {
			if(array[i]%2 == 0) {
				System.out.println(array[i]);
				System.out.println("Index numero : " + i + "\n");
			}
		}
		System.out.println("\n Nombres impairs \n");
		for(int i = 0; i < array.length; i++) {
			if(array[i]%2 == 1 || array[i]%2 == -1) {
				System.out.println(array[i]);
				System.out.println("Index numero : " + i + "\n");
			}
		}
	}

}
