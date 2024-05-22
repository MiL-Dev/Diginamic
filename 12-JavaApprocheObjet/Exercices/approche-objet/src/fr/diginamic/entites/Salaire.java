package fr.diginamic.entites;

public class Salaire {
	String lastName;
	String name;
	double salary;
	
	public Salaire (String lastName, String name,double salary) {
		this.lastName = lastName;
		this.name = name;
		this.salary = salary;
		
		
	}
	
	public void getSalaire() {
		System.out.println(lastName + " " + name + " " + " Salaire : " + salary + "$");
	}
}
//TEST DANS MANIPULATION DES CHAINES 