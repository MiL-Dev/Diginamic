package fr.diginamic;


import fr.diginamic.entity.Emprunt;
import fr.diginamic.entity.Livre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJpaBiblio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		
		transaction.begin();
		
		Livre livre1 = em.find(Livre.class, 1);
		
		for(Emprunt emprunt : livre1.getEmprunts()) {
			System.out.println(emprunt);

		}
		System.out.println(livre1.getTitre());
		
		Livre livre2 = new Livre();
		livre2.setAuteur("Auteur Livre2");
		livre2.setTitre("Titre 2");
		em.persist(livre2);
		
		
		transaction.commit();
		
		
		em.close();
	}

}
