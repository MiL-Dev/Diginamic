package projet3_Foot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

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
		EntityTransaction transaction = em.getTransaction();

//		Query query = em.createQuery("SELECT p FROM Person p WHERE p.name= :name");
//		query.setParameter("name", "Doe");

		// Creation des objetsEntite

		Set<MatchFoot> matchs = new HashSet<>(); // TODO changer en HashMap (utilisation de cle)
		Set<Player> players = new HashSet<>();
		Set<Team> teams = new HashSet<>();
		Set<GoalScorer> goalScorers = new HashSet<>();
		Set<Location> locations = new HashSet<>();
		Set<ShootOut> shootOuts = new HashSet<>();

		// fichier Result Lecture
		Path pathResult = Paths.get(
				"C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\results.csv");
		List<String> linesResult = null;

		try {
			linesResult = Files.readAllLines(pathResult);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}

		String linesColumnsResult = linesResult.remove(0);
		System.out.println(linesColumnsResult);

		for (String line : linesResult) {
			String[] elements = line.split(",", -1);// -1 permet de ne pas ignorer les cellules vides separer par ","
			MatchFoot match = new MatchFoot();

			LocalDate date = LocalDate.parse(elements[0]);
			match.setDate(date);

			Team teamHome = new Team();
			Team teamAway = new Team();

			if (teams.size() > 0) {
				boolean find = false;
				for (Team t : teams) {
					if (t.getName().equals(elements[1])) {
						teamHome = t;
						find = true;
					}
				}
				if (!find) {
					teamHome.setName(elements[1]);
				}
				find = false;
				for (Team t : teams) {
					if (t.getName().equals(elements[2])) {
						teamAway = t;
						find = true;
					}
				}
				if (!find) {
					teamAway.setName(elements[2]);
				}
			} else {
				teamHome.setName(elements[1]);
				teamAway.setName(elements[2]);
			}

			match.setHome(teamHome);
			match.setAway(teamAway);
			match.setHomeScore(Integer.parseInt(elements[3]));
			match.setAwayScore(Integer.parseInt(elements[4]));
			match.setTournament(elements[5]);

			Location locate = new Location();

			boolean find = false;
			locate.setCity(elements[6]);
			locate.setCountry(elements[7]);

			for (Location loc : locations) {

				if (loc.getCity().equals(elements[6]) && loc.getCountry().equals(elements[7])) {
					locate = loc;
					find = true;
				}
			}
			if (!find) {
				locate.setCity(elements[6]);
				locate.setCountry(elements[7]);
			}

			match.setLocation(locate);

			boolean neutral = false;
			if (elements[8] == "TRUE") {
				neutral = true;
			}
			match.setNeutral(neutral);

			// Methode contains verifier si la classe equals est redefinie !
			locations.add(locate);
			teams.add(teamHome);
			teams.add(teamAway);
			matchs.add(match);

		}

		// Fichier shootOut

		Path pathShootOut = Paths.get(
				"C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\shootouts.csv");
		List<String> linesShootOut = null;

		try {
			linesShootOut = Files.readAllLines(pathShootOut);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}

		String linesColumnsShootOut = linesShootOut.remove(0);
		System.out.println(linesColumnsShootOut);

		for (String line : linesShootOut) {

			String[] elements = line.split(",", -1);// -1 permet de ne pas ignorer les cellules vides separer par ","
			LocalDate date = LocalDate.parse(elements[0]);
			Optional<MatchFoot> filter = matchs.stream().filter(match -> match.getDate().equals(date)
					&& match.getHome().getName().equals(elements[1]) && match.getAway().getName().equals(elements[2]))
					.findFirst();

			if (filter.isPresent()) {
				ShootOut shootOut = new ShootOut();
				MatchFoot m = filter.get();
				if (m.getHome().getName().equals(elements[3])) {
					shootOut.setWinner(m.getHome());
				} else {
					shootOut.setWinner(m.getAway());
				}
				shootOut.setMatch(m);
				m.setShootOut(shootOut);

				shootOuts.add(shootOut);
			}
		}

		// Fichier goalscorers
		Path pathGoalScorers = Paths.get(
				"C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\24. Projet JPA\\Projet 3 - Football international\\goalscorers.csv");
		List<String> linesGoalScorers = null;

		try {
			linesGoalScorers = Files.readAllLines(pathGoalScorers);
		} catch (IOException e) {
			System.out.println("Le fichier est introuvable");
			e.printStackTrace();
		}

		String linesColumnsGoalScorers = linesGoalScorers.remove(0);
		System.out.println(linesColumnsGoalScorers);

		for (String line : linesGoalScorers) {
			String[] elements = line.split(",", -1);// -1 permet de ne pas ignorer les cellules vides separer par ","
			LocalDate date = LocalDate.parse(elements[0]);

			Optional<MatchFoot> filter = matchs.stream().filter(match -> match.getDate().equals(date)
					&& match.getHome().getName().equals(elements[1]) && match.getAway().getName().equals(elements[2]))
					.findFirst();

			if (filter.isPresent()) {
				MatchFoot m = filter.get();

				GoalScorer gS = new GoalScorer();
				Player pl = new Player();
				Team team = null;
				
				if (elements[3].equals(elements[1]) ) {
					team = m.getHome();
				} else {
					team = m.getAway();
				}
				if (players.size() > 0) {
					for (Player p : players) {
						if (p.getName().equals(elements[4])) {
							pl = p;

						} else {
							pl.setName(elements[4]);
						}
					}
				} else {
					pl.setName(elements[4]);
				}

				team.setPlayers(pl);
				pl.setTeam(team);
				gS.setMinute(elements[5]);
				gS.setOwn_goal(elements[6]);
				gS.setPenalty(elements[7]);
				gS.setPlayer(pl);
				gS.setMatch(m);
				gS.setTeam(team);
				pl.setGoalScorers(gS);
				m.setGoalScorers(gS);
				goalScorers.add(gS);
				players.add(pl);
			}
//			System.out.println(elements[0]); // colonne 1 les dates
		}

		transaction.begin();

		for (Location l : locations) {
			em.persist(l);
		}
		for (MatchFoot m : matchs) {

			em.persist(m);
		}
		for (Team t : teams) {
			em.persist(t);
		}
		for (ShootOut sh : shootOuts) {
			em.persist(sh);
		}

		for (Player p : players) {
			em.persist(p);
		}

		for (GoalScorer gs : goalScorers) {

			em.persist(gs);
		}

		transaction.commit();
		em.close();

	}
}
