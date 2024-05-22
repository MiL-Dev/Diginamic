package listes;

import java.util.ArrayList;
import java.util.Collections;

public class TestListeInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> numList = new ArrayList<>();
		
		numList.add(-1);
		numList.add(5);
		numList.add(7);
		numList.add(3);
		numList.add(-2);
		numList.add(4);
		numList.add(8);
		numList.add(5);
		
		for(Integer num : numList) {
			System.out.println(num);
		}
		System.out.println("Taille du tableau : "+numList.size());
		Integer maxNum = Collections.max(numList);
		System.out.println("Le plus grand du tableau : "+maxNum);
		Integer minNum = Collections.min(numList);
		numList.remove(minNum);
		System.out.println("Suppresion Valeur minimum : " + minNum );
		
		
		for(int i=0; i< numList.size(); i++) {
			if(numList.get(i) < 0) {
				numList.set(i,(numList.get(i) * numList.get(i)));
			}
		}
		
//		Iterator<Integer> iter = numList.iterator();
//		while(iter.hasNext()) {
//			Integer number = iter.next();
//
//		}
		
		System.out.println("Changer en nombre positif");
		for(Integer num : numList) {
			System.out.println(num);
		}
		
	}

}
