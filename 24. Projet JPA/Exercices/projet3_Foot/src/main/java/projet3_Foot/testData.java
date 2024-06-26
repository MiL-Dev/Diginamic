package projet3_Foot;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.MatchFootDao;
import dao.PlayerDao;
import entities.MatchFoot;
import entities.Player;

public class testData {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project3_football-init");
		EntityManager em = emf.createEntityManager();
		
		// Afficher les N meilleurs buteurs de tous les temps
		PlayerDao plDao = new PlayerDao(em);
		List<Player> players = plDao.extract();
		
		List<Player> bestScorer = players.stream().sorted((a, b) -> b.getGoalScorers().size() - a.getGoalScorers().size()).collect(Collectors.toList());
		
		for(int i=0; i<5; i++) {
			System.out.println(bestScorer.get(i) + " - Nombre de but : " + bestScorer.get(i).getGoalScorers().size());
		}
		
		List<Player> playersByName = plDao.extractByName("Cristiano");
		for(Player p : playersByName) {
			System.out.println(p);
		}
		Optional<Player> playerOne = plDao.extractOne(9757);
		
		if(playerOne.isPresent()) {
			System.out.println(playerOne.get() + " - " + playerOne.get().getTeam().getName());
		}
		
		MatchFootDao matDao = new MatchFootDao(em);
		
		List<MatchFoot> matchs = matDao.extract();
		
		List<MatchFoot> bestScorerTournament = matchs.stream().filter((m) -> m.getTournament().equals("Friendly")).sorted((a, b) -> b.getGoalScorers().size() - a.getGoalScorers().size()).collect(Collectors.toList());
	
		
	
	
	}

}
