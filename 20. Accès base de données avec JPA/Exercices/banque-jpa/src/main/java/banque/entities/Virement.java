package banque.entities;

import java.util.Date;

import jakarta.persistence.Entity;


@Entity
public class Virement extends Operation {
	
	
	
	private String beneficiaire;
	
	public Virement() {
		
	}
	public Virement(Date date, double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
