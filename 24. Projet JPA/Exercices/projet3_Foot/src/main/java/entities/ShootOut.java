package entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ShootOut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team winner;
	
	@OneToOne(mappedBy= "shootOut")
	private MatchFoot match;

	public ShootOut() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(match);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShootOut other = (ShootOut) obj;
		return Objects.equals(match, other.match);
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public MatchFoot getMatch() {
		return match;
	}

	public void setMatch(MatchFoot match) {
		this.match  = match;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
