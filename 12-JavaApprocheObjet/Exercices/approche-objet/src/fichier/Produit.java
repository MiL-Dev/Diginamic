package fichier;

public class Produit {
	String categorie;
	String marque;
	String nom;
	String grade;
	public Produit(String categorie, String marque, String nom, String grade) {
		super();
		this.categorie = categorie;
		this.marque = marque;
		this.nom = nom;
		this.grade = grade;
	}
	
	
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
