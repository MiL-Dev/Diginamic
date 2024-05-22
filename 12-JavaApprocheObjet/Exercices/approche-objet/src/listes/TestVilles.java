package listes;

import java.util.ArrayList;
import java.util.Iterator;

public class TestVilles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Ville> cityList = new ArrayList<>();
		Ville ville1 = new Ville("Nice",343000,Continent.EUROPE);
		cityList.add(ville1);
		
		cityList.add(new Ville("Carcassonne",47800,Continent.EUROPE)); // ajout direct dans la variable ville
		Ville ville3 = new Ville("Narbonne",53400,Continent.EUROPE);
		cityList.add(ville3);
		
		Ville ville4 = new Ville("Lyon",484000,Continent.EUROPE);
		cityList.add(ville4);
		
		Ville ville5 = new Ville("Foix",9700,Continent.EUROPE);
		cityList.add(ville5);
		
		Ville ville6 = new Ville("Pau",77200,Continent.EUROPE);
		cityList.add(ville6);
		
		Ville ville7 = new Ville("Marseille",850700,Continent.EUROPE);
		cityList.add(ville7);
		
		Ville ville8 = new Ville("Tarbes",40600,Continent.EUROPE);
		cityList.add(ville8);
		
		
		Iterator<Ville> iter = cityList.iterator();
		Ville cityMax = null;
		Ville cityMin = null;
		while (iter.hasNext()) {
			Ville city = iter.next();
			if (cityMax == null || cityMax.getNbHab() < city.getNbHab()) {
				cityMax = city;
			}
			
			if(cityMin == null || city.getNbHab() < cityMin.getNbHab()) {
				cityMin = city;
			}
		}
		System.out.println("La ville la plus peuple est : " + cityMax.getName());
		System.out.println("La ville la moins peuple est : " + cityMin.getName());
	}

}
