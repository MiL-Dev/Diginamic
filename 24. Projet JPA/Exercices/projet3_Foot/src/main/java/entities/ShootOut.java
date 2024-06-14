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
public class ShootOut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team winner;
	
	@OneToMany(mappedBy= "shootOut")
	private Set<MatchFoot> matchs = new HashSet<>();

	public ShootOut() {
		super();
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public Set<MatchFoot> getMatchs() {
		return matchs;
	}

	public void setMatchs(Set<MatchFoot> matchs) {
		this.matchs = matchs;
	}
}
