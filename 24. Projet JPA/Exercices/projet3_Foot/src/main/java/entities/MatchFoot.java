package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class MatchFoot {
	
	@Override
	public String toString() {
		return "MatchFoot [date=" + date + ", home=" + home + ", away=" + away + "]";
	}

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
	
	@OneToMany(mappedBy="match")
	private Set<GoalScorer> goalScorers = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="shoot_id")
	ShootOut shootOut;
	
	private String tournament;
	
	private boolean neutral;

	public MatchFoot() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(away, date, home);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchFoot other = (MatchFoot) obj;
		return Objects.equals(away, other.away) && Objects.equals(date, other.date) && Objects.equals(home, other.home);
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

	public void setGoalScorers(GoalScorer goalScorers) {
		this.goalScorers.add(goalScorers);
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
