package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.MatchFoot;

public class MatchFootDao implements GeneralDao<MatchFoot> {
private EntityManager em;
	
	public MatchFootDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<MatchFoot> extract() {
		TypedQuery<MatchFoot> query = em.createQuery("SELECT p FROM Player p", MatchFoot.class);
		List<MatchFoot> matchs = query.getResultList();
		return matchs;
	}
}
