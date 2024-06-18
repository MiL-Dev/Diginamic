package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String country;
	
	private String city;
	
	@OneToMany(mappedBy="location")
	private Set<MatchFoot> match = new HashSet<>();

	public Location() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<MatchFoot> getMatch() {
		return match;
	}

	public void setMatch(Set<MatchFoot> match) {
		this.match = match;
	}
}
