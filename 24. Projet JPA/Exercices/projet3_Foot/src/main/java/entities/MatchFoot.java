package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MatchFoot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="locat_id")
	private Location location;
	
	@ManyToOne
	@JoinColumn(name="home_id")
	private Team home;
	
	@ManyToOne
	@JoinColumn(name="away_id")
	private Team away;
	
	@Column(name="home_score")
	private int homeScore;
	
	@Column(name="away_score")
	private int awayScore;
	
	@ManyToMany
	@JoinTable(name="match_goal",
	joinColumns= @JoinColumn(name="id_match", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_goal", referencedColumnName="id")
	)
	private Set<GoalScorer> goalScorers = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="shoot_id")
	ShootOut shootOut;
	
	private String tournament;
	
	private boolean neutral;

	public MatchFoot() {
		super();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public Set<GoalScorer> getGoalScorers() {
		return goalScorers;
	}

	public void setGoalScorers(Set<GoalScorer> goalScorers) {
		this.goalScorers = goalScorers;
	}

	public ShootOut getShootOut() {
		return shootOut;
	}

	public void setShootOut(ShootOut shootOut) {
		this.shootOut = shootOut;
	}

	public String getTournament() {
		return tournament;
	}

	public void setTournament(String tournament) {
		this.tournament = tournament;
	}

	public boolean isNeutral() {
		return neutral;
	}

	public void setNeutral(boolean neutral) {
		this.neutral = neutral;
	}
}
