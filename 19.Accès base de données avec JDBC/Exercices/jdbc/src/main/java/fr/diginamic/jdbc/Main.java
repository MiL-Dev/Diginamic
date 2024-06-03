package fr.diginamic.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		ResourceBundle config = ResourceBundle.getBundle("database");
		String driverName = config.getString("database.driver");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String password = config.getString("database.password");

		System.out.println(driverName);
// Methode de CRUD sans DAO (CLASSE)
		try {
			
			//Utilisation de mariadb
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			
			//Connexion a la base de donnee
			Connection connection = DriverManager.getConnection(url, user, password);
			
			//Classe qui contient les methodes de CRUD
			
			Statement statement = connection.createStatement();
			
			// INSERT
			int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR (NAME) VALUES('Castorama')"); // executeUpdate
																									// renvoi un int (le
																									// nombre
																									// d'operation
			//UPDATE																						// effectuer)
			System.out.println(nb);
			statement.executeUpdate("UPDATE FOURNISSEUR SET NAME='CastoramaModifie' WHERE NAME='Castorama'");
			
			//DELETE
			statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE NAME='CastoramaModifie'");
			
			//READ
			ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR"); // executeQuery() renvoi une
																						// variable de type ResultSet

			ArrayList<Fournisseur> fournisseur = new ArrayList<>();

			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NAME");
				Fournisseur fournisseurCourant = new Fournisseur(id, nom);
				fournisseur.add(fournisseurCourant);
				System.out.println(fournisseurCourant.getName());
			}

			curseur.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
// Methode de CRUD avec DAO
		
		Connection connection = null;
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			connection = DriverManager.getConnection(url, user, password);
			Fournisseur ajoutFournisseur = new Fournisseur(0,"L'apostrophe");
			FournisseurDaoJdbc crudFournisseur = new FournisseurDaoJdbc(connection);
			crudFournisseur.insert(ajoutFournisseur);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e ) {
				System.err.println(e.getMessage());
			}
		}
	}
}