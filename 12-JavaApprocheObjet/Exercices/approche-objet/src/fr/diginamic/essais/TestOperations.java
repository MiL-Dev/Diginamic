package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operations op = new Operations();
		System.out.println(op.calcul(324, '+', 26));
		System.out.println(op.calcul(324, '-', 26));
		System.out.println(op.calcul(324, '*', 26));
		System.out.println(op.calcul(324, '/', 26));
		
	}

}
