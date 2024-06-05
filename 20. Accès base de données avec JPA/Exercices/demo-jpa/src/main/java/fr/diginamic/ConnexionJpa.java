package fr.diginamic;

import fr.diginamic.entity.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cours-JPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		
		transaction.begin();
		
		Region region = new Region();
		region.setNom("Midi-pyrenees");
		em.persist(region);
		
		Region reg1 = em.find(Region.class, 2);
		System.out.println(reg1.getNom());
		
		transaction.commit();
		
		transaction.begin();
		
		Region reg2 = em.find(Region.class, 2);
		
		transaction.commit();
		em.close();
	}

}
