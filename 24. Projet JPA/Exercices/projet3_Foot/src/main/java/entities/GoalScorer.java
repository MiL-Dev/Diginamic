package entities;

import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

@Entity
public class GoalScorer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="match_id")
	private MatchFoot match;
	
	@ManyToOne
	@JoinColumn(name="goal_team")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name="goal_play")
	private Player player;

	private String minute;
	
	private String own_goal;
	
	private String penalty;
	
	public GoalScorer() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(match, minute, player, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoalScorer other = (GoalScorer) obj;
		return Objects.equals(match, other.match) && Objects.equals(minute, other.minute)
				&& Objects.equals(player, other.player) && Objects.equals(team, other.team);
	}


	public MatchFoot getMatch() {
		return match;
	}

	public void setMatch(MatchFoot match) {
		this.match = match;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getOwn_goal() {
		return own_goal;
	}

	public void setOwn_goal(String own_goal) {
		this.own_goal = own_goal;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}
}
