package dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Player;

public class PlayerDao implements GeneralDao<Player> {
	
	private EntityManager em;
	
	public PlayerDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Player> extract() {
		TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p", Player.class);
		List<Player> goalScorer = query.getResultList();
		return goalScorer;
	}
	
	public Optional<Player> extractOne(Integer id) {
		
		Player query = em.find(Player.class, id);
		if(query != null) {
			return Optional.of(query);
		}
		return null;
	}
	
	public List<Player> extractByName(String player) {
		TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE name LIKE :name", Player.class);
		query.setParameter("name", "%"+ player + "%");
		List<Player> players = query.getResultList();
		
		return players;
	}
	
}
