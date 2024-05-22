package fr.diginamic.formes;

public class Rectangle extends Forme {
	double leng;
	double wid;
	
	public Rectangle(double leng, double wid) {
		this.leng = leng;
		this.wid = wid;
	}

	public double perimeter() {
		return (this.leng + this.wid) * 2;
	}
	public double surface() {
		return this.leng * this.wid ;
	}
}
