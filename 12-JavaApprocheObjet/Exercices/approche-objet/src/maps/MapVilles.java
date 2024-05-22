package maps;


import java.util.HashMap;

import fichier.Ville;

public class MapVilles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Ville> citiesMap = new HashMap<>();
		
		Ville ville1 = new Ville("Nice","343000","nom de region", 1000);
		Ville ville3 = new Ville("Narbonne","53400","nom de region", 2000);		
		Ville ville4 = new Ville("Lyon","484000","nom de region", 100);		
		Ville ville5 = new Ville("Foix","9700","nom de region", 5000);		
		Ville ville6 = new Ville("Pau","77200","nom de region", 41000);
		Ville ville7 = new Ville("Marseille","850700","nom de region", 21000);	
		Ville ville8 = new Ville("Tarbes","40600","nom de region", 541000);
		
		citiesMap.put(ville1.getName(), ville1);
		citiesMap.put(ville3.getName(), ville3);
		citiesMap.put(ville4.getName(), ville4);
		citiesMap.put(ville5.getName(), ville5);
		citiesMap.put(ville6.getName(), ville6);
		citiesMap.put(ville7.getName(), ville7);
		citiesMap.put(ville8.getName(), ville8);
		int lowerPopulation = citiesMap.get(ville1.getName()).getPopulationTotal();
		Ville vLower = citiesMap.get("Nice");
		
		System.out.println("Taille avant traitement des habitants : "+citiesMap.size());
		System.out.println(vLower.getName() + " est la plus petit ville de : " + vLower.getPopulationTotal() + " habitant\nElle sera supprimer");
		
		for(String key : citiesMap.keySet()) {
			Ville v = citiesMap.get(key);
			System.out.println(v.getPopulationTotal());
			if(lowerPopulation > v.getPopulationTotal()) {
				lowerPopulation = v.getPopulationTotal();
				vLower =v;
			}
		}
		
		citiesMap.remove(vLower.getName());
		System.out.println("Taille apres traitement de la ville la plus basse en population : "+citiesMap.size()+"\n");
		for(String key : citiesMap.keySet()) {
			Ville v = citiesMap.get(key);
			System.out.println(key + " - " + v);
		}
	
	}
		
	}


