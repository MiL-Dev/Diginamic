package maps;

import java.util.ArrayList;
import java.util.HashMap;

public class ComptagePaysParContinent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pays> countries = new ArrayList<>();
		countries.add(new Pays("France", 65, "Europe"));
		countries.add(new Pays("Allemagne", 80, "Europe"));
		countries.add(new Pays("Belgique", 10, "Europe"));
		countries.add(new Pays("Russie", 150, "Asie"));
		countries.add(new Pays("Chine", 1400, "Asie"));
		countries.add(new Pays("Indonésie", 220, "Océanie"));
		countries.add(new Pays("Australie", 20, "Océanie"));
		
		
		//A corriger ...
		HashMap<String, Integer> mapCountries = new HashMap<>();
		int compteurEurope = 0;
		int compteurAsis = 0;
		int compteurOceanie = 0;
		for(Pays country : countries) {
			switch(country.getMainland()) {
				case "Europe":
					compteurEurope += 1;
					break;
				case "Asie":
					compteurEurope += 1;
					break;
				case "Océanie":
					compteurEurope += 1;
					break;
			}

			mapCountries.put(country.getMainland(), country.getPopulation());
		}
		System.out.println(mapCountries.size());
	}
	
}
