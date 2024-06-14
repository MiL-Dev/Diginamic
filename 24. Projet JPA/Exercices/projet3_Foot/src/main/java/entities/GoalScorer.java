package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GoalScorer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name="match_goal",
	joinColumns= @JoinColumn(name="id_goal", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_match", referencedColumnName="id")
	)
	private Set<MatchFoot> matchs = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="goal_play")
	private Player player;

	public GoalScorer() {
		super();
	}

	public Set<MatchFoot> getMatchs() {
		return matchs;
	}

	public void setMatchs(Set<MatchFoot> matchs) {
		this.matchs = matchs;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
