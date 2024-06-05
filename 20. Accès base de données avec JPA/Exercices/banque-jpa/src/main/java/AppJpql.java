
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import banque.entities.Adresse;
import banque.entities.Banque;
import banque.entities.Client;
import banque.entities.Compte;
import banque.entities.LivretA;
import banque.entities.Operation;
import banque.entities.Virement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AppJpql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query= em.createQuery("SELECT p FROM Person p WHERE p.name= :name");
		query.setParameter("name", "Doe");
		
		
	}

}
