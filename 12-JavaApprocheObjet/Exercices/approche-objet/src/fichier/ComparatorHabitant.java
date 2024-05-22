package fichier;

import java.util.Comparator;

public class ComparatorHabitant implements Comparator<Ville>{
	
	@Override
	public int compare(Ville o1, Ville o2) {
		// TODO Auto-generated method stub
		if(o1.populationTotal > o2.getPopulationTotal()) {
			return 1;
		}else if(o1.populationTotal < o2.getPopulationTotal()) {
			return -1;
		}
		return 0;
	}

}
