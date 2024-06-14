package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_team")
	private Team team;
	
	@OneToMany(mappedBy="player")
	private Set<GoalScorer> goalScorers = new HashSet<>();

	public Player() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Set<GoalScorer> getGoalScorers() {
		return goalScorers;
	}

	public void setGoalScorers(Set<GoalScorer> goalScorers) {
		this.goalScorers = goalScorers;
	}
}
