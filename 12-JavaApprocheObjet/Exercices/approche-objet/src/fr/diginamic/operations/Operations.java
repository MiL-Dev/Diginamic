package fr.diginamic.operations;

public class Operations {
	public double calcul(double a,char o, double b ) {
		double result = 0;
		
		switch (o) {
		case '+':  
			result = a + b;
			break;
		case '-':
			result =  a - b;
			break;
		case '*':
			result = a * b;
		case '/':
			result = a / b;
		}
		return result;
	}
}
