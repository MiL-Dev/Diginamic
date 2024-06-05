package banque.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte {
	
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	private double taux;

	public AssuranceVie( String numero, double solde, Date dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}
	
}
