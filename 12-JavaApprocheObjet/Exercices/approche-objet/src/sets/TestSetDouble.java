package sets;

import java.util.Collections;
import java.util.HashSet;

public class TestSetDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Double> set = new HashSet<>();
		set.add(1.5);
		set.add(8.25);
		set.add(-7.32);
		set.add(13.3);
		set.add(-12.45);
		set.add(48.5);
		set.add(0.01);
		System.out.println(set);
		
		Double setMax = Collections.max(set);
		
		System.out.println(setMax);
		
		Double setMin = Collections.min(set);
		
		System.out.println(setMin);
		set.remove(setMin);
		
		System.out.println(set);
		
	}

}
