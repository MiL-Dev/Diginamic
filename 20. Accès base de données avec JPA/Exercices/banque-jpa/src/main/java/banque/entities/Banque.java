package banque.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Banque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	@OneToMany(mappedBy="banque")
	
	private Set<Client> client = new HashSet<>();

	
	public Banque(String nom) {
		super();
		this.nom = nom;
	}
	public Banque() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Client> getClient() {
		return client;
	}
	public void setClient(Set<Client> client) {
		this.client = client;
	}
	
}
