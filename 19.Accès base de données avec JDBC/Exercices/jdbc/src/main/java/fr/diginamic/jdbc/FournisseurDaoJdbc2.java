package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc2 implements GeneralDao<Fournisseur> {
	Connection connection;
	
	
	
	public FournisseurDaoJdbc2(Connection connection) {
		super();
		this.connection = connection;
		
	}

	@Override
	public List<Fournisseur> extraire() {
		ArrayList<Fournisseur> fournisseur = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet curseur = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM FOURNISSEUR");
			curseur = statement.executeQuery();
			
			

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
				statement.close();
				curseur.close();
			}catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}
		
		return fournisseur;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("INSERT INTO FOURNISSEUR (NAME) VALUES(?)");
			statement.setString(1, fournisseur.getName());
			statement.execute();
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
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("UPDATE FOURNISSEUR SET NAME='?' WHERE NAME='?'");
			statement.setString(1, nouveauNom);
			statement.setString(2, ancienNom);
			statement.executeUpdate();
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
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE NAME=?");
			statement.setString(1, fournisseur.getName());
			statement.executeUpdate();
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
