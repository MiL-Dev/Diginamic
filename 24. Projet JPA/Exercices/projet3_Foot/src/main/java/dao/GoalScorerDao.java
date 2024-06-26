package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.GoalScorer;

public class GoalScorerDao implements GeneralDao<GoalScorer> {

	private EntityManager em;

	public GoalScorerDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<GoalScorer> extract() {
		TypedQuery<GoalScorer> query = em.createQuery("SELECT g FROM GoalScorer g", GoalScorer.class);
		List<GoalScorer> goalScorer = query.getResultList();
		return goalScorer;
	}

	public List<GoalScorer> extractBestGoal(int number) {
		TypedQuery<GoalScorer> query = em.createQuery("SELECT g FROM GoalScorer g ", GoalScorer.class);
		List<GoalScorer> goalScorer = query.getResultList();
		query.setParameter("number", number);
		return goalScorer;
	}

}
