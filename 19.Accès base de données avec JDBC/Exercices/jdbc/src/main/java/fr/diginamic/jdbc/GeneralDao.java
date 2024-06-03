package fr.diginamic.jdbc;

import java.util.List;

public interface GeneralDao<T> {
	List<T> extraire();

	void insert(T object);

	int update(String ancienNom, String nouveauNom);

	boolean delete(T object);
}
