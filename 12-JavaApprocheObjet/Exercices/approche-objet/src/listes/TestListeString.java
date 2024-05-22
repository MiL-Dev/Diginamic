package listes;

import java.util.ArrayList;

public class TestListeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("Nice");
		stringList.add("Carcassonne");
		stringList.add("Narbonne");
		stringList.add("Foix");
		stringList.add("Pau");
		stringList.add("Marseille");
		stringList.add("Tarbes");
		
		String result ="";
		for(String city : stringList) {
			if(result.length() < city.length()) {
				result = city;
			}
			
		}
		System.out.println(result);
		
		for(int i=0; i< stringList.size(); i++) {
			stringList.set(i, stringList.get(i).toUpperCase());
			System.out.println(stringList.get(i));
		}
		
		for(int i=0; i< stringList.size(); i++) {
			String nom = stringList.get(i);
			if (nom.startsWith("N")) {
				System.out.println("Ville supprimer : " + nom);
				stringList.remove(i);
			}
		}
		System.out.println("La liste de ville restante : " + stringList);
	}

}
