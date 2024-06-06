package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEG")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="ID_MARQ")
	private Marque marque;
	
	private String scoreNutritionnel;
	
	private double valeurNutritionnel;
	
	@ManyToMany
	@JoinTable(name="PRO_ING",
		joinColumns=@JoinColumn(name="ID_PRO", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_ING", referencedColumnName="ID")
	)
	private Set<Ingredient> ingredients;
	
	@ManyToMany
	@JoinTable(name="PRO_ALLERG",
		joinColumns=@JoinColumn(name="ID_PRO", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_ALLERG", referencedColumnName="ID")
	)
	private Set<Allergene> Allergenes;
	
	@ManyToMany
	@JoinTable(name="PRO_ADDIT",
		joinColumns=@JoinColumn(name="ID_PRO", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_ADDIT", referencedColumnName="ID")
	)
	private Set<Additif> Additifs;
	
	public Produit() {
		super();
	}

	public Produit(Categorie categorie, Marque marque, String scoreNutritionnel, double valeurNutritionnel,
			Set<Ingredient> ingredients, Set<Allergene> Allergenes, Set<Additif> Additifs) {
		super();
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutritionnel = scoreNutritionnel;
		this.valeurNutritionnel = valeurNutritionnel;
		this.ingredients = ingredients;
		this.Allergenes = Allergenes;
		this.Additifs = Additifs;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public String getScoreNutritionnel() {
		return scoreNutritionnel;
	}

	public void setScoreNutritionnel(String scoreNutritionnel) {
		this.scoreNutritionnel = scoreNutritionnel;
	}

	public double getValeurNutritionnel() {
		return valeurNutritionnel;
	}

	public void setValeurNutritionnel(int valeurNutritionnel) {
		this.valeurNutritionnel = valeurNutritionnel;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Allergene> getAllergenes() {
		return Allergenes;
	}

	public void setAllergenes(Set<Allergene> Allergenes) {
		this.Allergenes = Allergenes;
	}

	public Set<Additif> getAdditifs() {
		return Additifs;
	}

	public void setAdditifs(Set<Additif> Additifs) {
		this.Additifs = Additifs;
	}
	
}
