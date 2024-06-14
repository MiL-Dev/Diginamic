package java17;

public class clCalcul {

	public Double exec(Double a, Double b, iOperation operation) {
		return operation.apply(a, b);
	}

	public static void main(String[] args) {
		clCalcul calcul = new clCalcul();
		iOperation addition = (c, d) -> c + d;
		iOperation soustraction = (c, d) -> c - d;

		System.out.println(calcul.exec(120.10, 25.20, addition));
		System.out.println(calcul.exec(80.20, 25.20, soustraction));
	}

}
