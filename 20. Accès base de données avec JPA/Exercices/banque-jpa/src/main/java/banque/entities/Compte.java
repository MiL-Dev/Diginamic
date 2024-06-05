package banque.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String numero;
	@JoinTable(name="COMPO",
			joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
		)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="COMPTE_CLIENT",
	joinColumns= @JoinColumn(name="ID-COMPTE", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID")
	)
	private Set<Client> clients = new HashSet<>();
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operation = new HashSet<>();

	public Compte(String numero, double solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}
	public Compte() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Set<Operation> getOperation() {
		return operation;
	}
	public void setOperation(Set<Operation> operation) {
		this.operation = operation;
	}
}
