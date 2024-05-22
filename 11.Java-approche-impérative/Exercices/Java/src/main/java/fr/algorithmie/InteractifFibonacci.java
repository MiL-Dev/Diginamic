package fr.algorithmie;

import java.util.Arrays;
import java.util.Scanner;

public class InteractifFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Dans cette exercice j'ai utiliser volontairement un double car les nombres peuvent etre tres tres grand selon le rang N que vous demandez
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuilles choisir le rang N");
		int scan = scanner.nextInt();
		double[] result = testFibonacci(scan);
		System.out.println(Arrays.toString(result));
		scanner.close();
	}
	public static double[] testFibonacci(int n) {
		double[] arrayN = new double[0];
		double n0 = 0;
		double n1 = 1;
		for(int i = 0; i<n; i++) {
			arrayN = Arrays.copyOf(arrayN,arrayN.length+1);
			arrayN[i] = n0 + n1;
			n0 = n1;
			n1 = arrayN[i];
		}
		return arrayN ;
	}

}
