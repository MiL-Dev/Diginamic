package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Lob
	private String libelle;
	
	@ManyToMany
	@JoinTable(name="PRO_ING",
		joinColumns=@JoinColumn(name="ID_ING", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_PRO", referencedColumnName="ID")
	)
	private Set<Produit> produits;

	public Ingredient(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Ingredient() {
		super();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
}
