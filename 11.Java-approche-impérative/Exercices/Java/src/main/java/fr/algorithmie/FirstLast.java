package fr.algorithmie;

public class FirstLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,1}; //Changer les valeurs pour tester la condition
		boolean value = false;
		if(array.length >= 1 && array[0] == array[array.length-1]) {
			value = true;
		}
		System.out.println(Boolean.toString(value));
	}
	
}
