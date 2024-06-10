package java17.cours;

import java.util.List;

public class clCalcul {

	public Double exec(Double a, Double b, iOperation operation) {
		return operation.apply(a, b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clCalcul calcul = new clCalcul();
		iOperation addition = (c,d) -> c + d;
		iOperation soustraction = (c,d) -> c - d;
		
		System.out.println(calcul.exec(120.10, 25.20, addition));
		System.out.println(calcul.exec(80.20, 25.20, soustraction));
		
		List<Integer> lSolde = List.of(0,-1,20,30,-20,150,120);
		Integer sommeS = lSolde.stream().map(s->s).filter(m->m>100).reduce((s1,s2)->s1+s2).get(); //SELECT sum(s) FROM lSolde WHERE s>100; 
		System.out.println(sommeS);
	}

}
