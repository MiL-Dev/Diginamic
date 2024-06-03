package fr.diginamic.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		ResourceBundle config = ResourceBundle.getBundle("database");
		String driverName = config.getString("database.driver");
		String url = config.getString("database.url");
		String user = config.getString("database.user");
		String password = config.getString("database.password");

		System.out.println(driverName);
				
// Methode de CRUD avec DAO
		
		Connection connection = null;
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			connection = DriverManager.getConnection(url, user, password);
			Fournisseur ajoutFournisseur = new Fournisseur(0,"L'apostrophe"); //avec le prepareStatement on peu maintenant mettre les apostrophes et cela ameliorer la securite du au injection SQL
			FournisseurDaoJdbc2 crudFournisseur = new FournisseurDaoJdbc2(connection);
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