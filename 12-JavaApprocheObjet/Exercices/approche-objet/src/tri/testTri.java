package tri;

import java.util.ArrayList;
import java.util.Collections;

public class testTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Ville> cities = new ArrayList<>();
		Ville ville1 = new Ville("Nice",343000);
		cities.add(ville1);
		
		cities.add(new Ville("Carcassonne",47800)); // ajout direct dans la variable ville
		Ville ville3 = new Ville("Narbonne",53400);
		cities.add(ville3);
		
		Ville ville4 = new Ville("Lyon",484000);
		cities.add(ville4);
		
		Ville ville5 = new Ville("Foix",9700);
		cities.add(ville5);
		
		Ville ville6 = new Ville("Pau",77200);
		cities.add(ville6);
		
		Ville ville7 = new Ville("Marseille",850700);
		cities.add(ville7);
		
		Ville ville8 = new Ville("Tarbes",40600);
		cities.add(ville8);
		
		Collections.sort(cities);
		for(Ville c : cities) {
			System.out.println(c.toString());
		}
		
	}

}
