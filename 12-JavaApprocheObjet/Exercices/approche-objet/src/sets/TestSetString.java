package sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class TestSetString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> setCountries = new HashSet<>();
		
		setCountries.add("USA");
		setCountries.add("France");
		setCountries.add("Allemagne");
		setCountries.add("UK");
		setCountries.add("Italie");
		setCountries.add("Japon");
		setCountries.add("Chine");
		Collections.addAll(setCountries, "Inde","Russie"); // permet d'ajouter directement au lieu de faire des add
		
		System.out.println(setCountries);
		
		String countryMaxLength ="";
		String countryMax = "";
		Iterator<String> iter = setCountries.iterator();
		while (iter.hasNext()) {
			String country = iter.next();
			if(country.length() < countryMaxLength.length()) {
				countryMax = country;
			}
			countryMaxLength = country;
		}
		System.out.println(countryMax);
		setCountries.remove(countryMax);
	}
//EXERCICE 2 TERMINER
}
