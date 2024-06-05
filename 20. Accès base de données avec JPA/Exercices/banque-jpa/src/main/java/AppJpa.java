
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

public class AppJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		
		@SuppressWarnings("deprecation")
		Date date1 = new Date(125, 11 , 3);
		

		Client client1 = new Client("Nom1","Prenom1", date1, new Adresse(12, "rue", 30000, "Ville1"));
		
		

		
		Set<Client> clients = new HashSet<>();
		
		Banque banque1 = new Banque("Banque1");
		client1.setBanque(banque1);
		
		banque1.setClient(clients);
		transaction.begin();
		em.persist(banque1);
		em.persist(client1);
		
		transaction.commit();
		
		Compte compte1 = new Compte("EUCompteClassique01", 1000);
		
		Set<Operation> ops = new HashSet<>();
		
		
		LivretA livretA1 = new LivretA("EU213141", 1000, 2);
		Operation op1 = new Operation( date1 , 2000, "Motif1");
		
		Virement virement = new Virement(date1, 200, "paiement", "beneficiaire1");
		virement.setCompte(compte1);
		
		transaction.begin();
		
		
		em.persist(livretA1);
		em.persist(op1);
		em.persist(compte1);
		em.persist(virement);
		
		
		
		transaction.commit();

		em.close();
	}

}
