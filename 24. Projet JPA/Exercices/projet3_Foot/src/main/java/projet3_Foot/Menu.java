package projet3_Foot;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PlayerDao;
import entities.Player;

public class Menu {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("project3_football-init");
	EntityManager em = emf.createEntityManager();
	
	
	
	public static void menu() {
		System.out.println("Taper votre choix");
		
		System.out.println("Choix 1 : Afficher les N meilleurs buteurs de tous les temps");
		
		System.out.println("Choix 2 : Afficher les N meilleurs buteurs d’une compétition donnée");
		
		System.out.println("Choix 3 : Afficher les N meilleurs buteurs d’une équipe donnée");
		
		System.out.println("Choix 4 : Afficher les N équipes qui ont gagné le plus de match en %");
		
		System.out.println("Choix 5 : Afficher les matchs entre 2 équipes données et afficher le % de victoire de chaque équipe.");
	}
	public void choix1() {
		// Afficher les N meilleurs buteurs de tous les temps
				PlayerDao plDao = new PlayerDao(em);
				List<Player> players = plDao.extract();
				
				List<Player> bestScorer = players.stream().sorted((a, b) -> b.getGoalScorers().size() - a.getGoalScorers().size()).collect(Collectors.toList());
				
				for(int i=0; i<5; i++) {
					System.out.println(bestScorer.get(i) + " - Nombre de but : " + bestScorer.get(i).getGoalScorers().size());
				}
	}
	
	public void choix2() {
		// Afficher les N meilleurs buteurs de tous les temps
				PlayerDao plDao = new PlayerDao(em);
				List<Player> players = plDao.extract();
				
				List<Player> bestScorer = players.stream().sorted((a, b) -> b.getGoalScorers().size() - a.getGoalScorers().size()).collect(Collectors.toList());
				
				for(int i=0; i<5; i++) {
					System.out.println(bestScorer.get(i) + " - Nombre de but : " + bestScorer.get(i).getGoalScorers().size());
				}
	}
	
	
}
