package fr.diginamic.operations;

import java.util.Arrays;

public class CalculMoyenne {
	private double[] array = new double[0];
	
	public double calculAverage() {
		double result = 0;
		for(double a : array) {
			result += a;
		}
		return result/array.length;	
	}
	
	public void setArray (double num) {
		array=Arrays.copyOf(array , array.length + 1);
		array[array.length - 1] = num;
	}
}
//tab=Arrays.copyOf(tab , tab length + 1)