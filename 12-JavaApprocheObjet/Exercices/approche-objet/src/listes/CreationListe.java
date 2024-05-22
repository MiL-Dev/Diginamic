package listes;

import java.util.ArrayList;

public class CreationListe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> number = new ArrayList<>();
		for(int i=0; i<100; i++) {
			number.add(i);
		}
		System.out.println(number.size());
	}

}
