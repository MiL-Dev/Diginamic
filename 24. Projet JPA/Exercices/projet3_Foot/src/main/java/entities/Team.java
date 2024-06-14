package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	@OneToMany(mappedBy="home")
	private Set<MatchFoot> matchsHome = new HashSet<>();
	
	@OneToMany(mappedBy="away")
	private Set<MatchFoot> matchsAway = new HashSet<>();
	
	@OneToMany(mappedBy="team")
	private Set<Player> players = new HashSet<>();
	
	@OneToMany(mappedBy="winner")
	private Set<ShootOut> shootOuts = new HashSet<>();

	public Team() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MatchFoot> getMatchsHome() {
		return matchsHome;
	}

	public void setMatchsHome(Set<MatchFoot> matchsHome) {
		this.matchsHome = matchsHome;
	}

	public Set<MatchFoot> getMatchsAway() {
		return matchsAway;
	}

	public void setMatchsAway(Set<MatchFoot> matchsAway) {
		this.matchsAway = matchsAway;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Set<ShootOut> getShootOuts() {
		return shootOuts;
	}

	public void setShootOuts(Set<ShootOut> shootOuts) {
		this.shootOuts = shootOuts;
	}
	
}
