package projet3_Foot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.GoalScorer;
import entities.Location;
import entities.MatchFoot;
import entities.Player;
import entities.ShootOut;
import entities.Team;

public class AddData {

	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project3_football");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= em.getTransaction();
		
//		Query query = em.createQuery("SELECT p FROM Person p WHERE p.name= :name");
//		query.setParameter("name", "Doe");
		
		//Creation des objetsEntite
		
		Set<MatchFoot> matchs = new HashSet<>();
		Set<Team> teams = new HashSet<>();
		Set<Player> players = new HashSet<>();
		Set<GoalScorer> goalScorers = new HashSet<>();
		Set<ShootOut> shootOuts = new HashSet<>();
		Set<Location> locations = new HashSet<>();
		//fichier Result Lecture
		Path pathResult = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\results.csv");
		List<String> linesResult = null;
		
		
		try {
			linesResult = Files.readAllLines(pathResult);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}
		
		String linesColumnsResult = linesResult.remove(0);
		System.out.println(linesColumnsResult);
		
		
		for(String line : linesResult) {
			String[] elements = line.split(",", -1);//-1 permet de ne pas ignorer les cellules vides separer par ","
			MatchFoot match = new MatchFoot();
			LocalDate date = LocalDate.parse(elements[0]);
			match.setDate(date);
			
			Team teamHome = new Team();
			teamHome.setName(elements[1]);
			match.setHome(teamHome);
			
			Team teamAway = new Team();
			teamAway.setName(elements[2]);
			match.setHome(teamAway);
			
			match.setHomeScore(Integer.parseInt(elements[3]));
			match.setAwayScore(Integer.parseInt(elements[4]));
			match.setTournament(elements[5]);
			
			Location locate = new Location();
			locate.setCity(elements[6]);
			locate.setCountry(elements[7]);
			match.setLocation(locate);
			boolean neutral = false;
			if(elements[8] == "TRUE") {
				neutral = true;
			}
			match.setNeutral(neutral);
			
			matchs.add(match);
		}
		
		//Fichier shootOut
		
		Path pathShootOut = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\shootouts.csv");
		List<String> linesShootOut = null;
		
		
		try {
			linesShootOut = Files.readAllLines(pathShootOut);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}
		
		String linesColumnsShootOut = linesShootOut.remove(0);
		System.out.println(linesColumnsShootOut);
		
		
		for(String line : linesShootOut) {
			String[] elements = line.split(",", -1);//-1 permet de ne pas ignorer les cellules vides separer par ","
		
//			System.out.println(elements[0]); // colonne 1 les dates
		}
		
		Path pathGoalScorers = Paths.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\goalscorers.csv");
		List<String> linesGoalScorers = null;
		
		
		try {
			linesGoalScorers = Files.readAllLines(pathGoalScorers);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}
		
		String linesColumnsGoalScorers = linesGoalScorers.remove(0);
		System.out.println(linesColumnsGoalScorers);
		
		
		for(String line : linesGoalScorers) {
			String[] elements = line.split(",", -1);//-1 permet de ne pas ignorer les cellules vides separer par ","
		
//			System.out.println(elements[0]); // colonne 1 les dates
		}
		transaction.begin();
		
		transaction.commit();
		em.close();
		
	}
}
