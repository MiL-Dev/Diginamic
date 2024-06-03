package fr.diginamic.jdbc.recensement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.GeneralDao;

public class DepartementDaoJdbc implements GeneralDao<Departement> {
	Connection connection;

	public DepartementDaoJdbc(Connection connection) {
		super();
		this.connection = connection;

	}

	@Override
	public List<Departement> extraire() {
		ArrayList<Departement> departement = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet curseur = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM FOURNISSEUR");
			curseur = statement.executeQuery();

			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NAME");
				Departement departementCourant = new Departement(id, nom);
				departement.add(departementCourant);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				statement.close();
				curseur.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

		return departement;
	}

	@Override
	public void insert(Departement object) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Departement object) {
		// TODO Auto-generated method stub
		return false;
	}

}
