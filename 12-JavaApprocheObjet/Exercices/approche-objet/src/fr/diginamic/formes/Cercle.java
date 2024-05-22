package fr.diginamic.formes;

public class Cercle extends Forme {
	double ray;
	public Cercle (double r) {
		ray = r;
	}
	public double perimeter() {
		return this.ray * 2 * Math.PI;
	}
	public double surface() {
		return (this.ray * this.ray) * Math.PI; 
	}
}
