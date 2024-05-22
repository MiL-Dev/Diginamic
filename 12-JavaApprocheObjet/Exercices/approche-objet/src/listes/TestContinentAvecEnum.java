package listes;

import java.util.ArrayList;

public class TestContinentAvecEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Ville> cityList = new ArrayList<>();
		
		Ville ville1 = new Ville("Paris",91, Continent.EUROPE);
		Ville ville2 = new Ville("New York",32141, Continent.AMERIQUE);
		Ville ville3 = new Ville("Pékin",92131, Continent.ASIE);
		Ville ville4 = new Ville("Sydney",91, Continent.AMERIQUE);
		Ville ville5 = new Ville("Sao Paulo",91, Continent.OCEANIE);
		Ville ville6 = new Ville("Dakar",91, Continent.AFRIQUE);
		
		cityList.add(ville1);
		cityList.add(ville2);
		cityList.add(ville3);
		cityList.add(ville4);
		cityList.add(ville5);
		cityList.add(ville6);
		
		for(Ville city : cityList) {
			System.out.println(city.toString());
		}
	}

}
