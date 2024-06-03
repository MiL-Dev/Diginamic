package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc implements GeneralDao<Fournisseur> {
	Connection connection;
	
	
	
	public FournisseurDaoJdbc(Connection connection) {
		super();
		this.connection = connection;
		
	}

	@Override
	public List<Fournisseur> extraire() {
		ArrayList<Fournisseur> fournisseur = new ArrayList<>();
		Statement statement = null;
		ResultSet curseur = null;
		try {
			statement = connection.createStatement();
			curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");
			
			

			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NAME");
				Fournisseur fournisseurCourant = new Fournisseur(id, nom);
				fournisseur.add(fournisseurCourant);
				System.out.println(fournisseurCourant.getName());
			}
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				curseur.close();
				statement.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
		
		return fournisseur;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO FOURNISSEUR (NAME) VALUES('%s')", fournisseur.getName()));
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		int r =0;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			r = statement.executeUpdate("UPDATE FOURNISSEUR SET NAME='CastoramaModifie' WHERE NAME='Castorama'");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
		return r;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE NAME='CastoramaModifie'");
			return true;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}finally {
			try {
				statement.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
	
	}

}
