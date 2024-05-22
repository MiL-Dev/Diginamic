package fr.diginamic.entites;

public class Cercle {
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
