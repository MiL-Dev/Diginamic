package fr.diginamic.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DATE_DEBUT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;
	
	@Column(name="DELAI")
	private int delai;
	
	@Column(name="DATE_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private List<Livre> livres = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	
	public Emprunt() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date date_debut) {
		this.dateDebut = date_debut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date date_fin) {
		this.dateFin = date_fin;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + dateDebut + ", delai=" + delai + ", date_fin=" + dateFin
				+ ", livres=" +  "]";
	}
}
