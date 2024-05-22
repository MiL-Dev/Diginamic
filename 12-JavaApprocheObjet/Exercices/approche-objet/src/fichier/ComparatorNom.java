package fichier;

import java.util.Comparator;

public class ComparatorNom  implements Comparator<Ville>{

	@Override
	public int compare(Ville o1, Ville o2) {
		// TODO Auto-generated method stub
		return o1.nameRegion.compareTo(o2.getNameRegion()); //Tri en ordre alphabetique
	}

}


	
