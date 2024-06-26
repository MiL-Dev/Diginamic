package fr.diginamic.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service implements IElement {
	
	private String nom;
	
	private List<IElement> elements = new ArrayList<>();
	
	public Service(String nom, IElement... element) {
		super();
		this.nom = nom;
		Collections.addAll(this.elements, element);
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<IElement> getElements() {
		return elements;
	}


	public void setElements(List<IElement> elements) {
		this.elements = elements;
	}


	


	@Override
	public double calculerSalaire() {
		// TODO Auto-generated method stub
		double result = 0;
		for(IElement el : elements) {
			result += el.calculerSalaire();
		}
		return result;
	}
}
