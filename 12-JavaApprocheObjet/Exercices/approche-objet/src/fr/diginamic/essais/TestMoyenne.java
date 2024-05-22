package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculMoyenne first = new CalculMoyenne();
		CalculMoyenne second = new CalculMoyenne();
		
		first.setArray(18);
		first.setArray(18);
		first.setArray(18);
		first.setArray(18);
		first.setArray(18);
		first.setArray(18);
		first.setArray(18);
		
		second.setArray(12);
		second.setArray(16);
		second.setArray(14);
		second.setArray(11);
		second.setArray(5);
		second.setArray(0);
		
		System.out.println(first.calculAverage());
		System.out.println(second.calculAverage());
	}

}
