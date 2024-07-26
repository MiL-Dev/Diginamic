
package fr.diginamic.hello.entities;

import java.util.ArrayList;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities;
    public UserAccount() {}
    public UserAccount(String username, String password, String role) {
        super();
        this.username = username;
        this.password = password;
        GrantedAuthority roleAuthority = new SimpleGrantedAuthority(role);
        this.authorities = new ArrayList<>();
        this.authorities.add(roleAuthority);
    }

    public UserDetails asUserDetails() {
        return new User(username, password, authorities);
    }
    
    public int getId() {
 		return id;
 	}

 	public void setId(int id) {
 		this.id = id;
 	}

 	public String getUsername() {
 		return username;
 	}

 	public void setUsername(String username) {
 		this.username = username;
 	}

 	public String getPassword() {
 		return password;
 	}

 	public void setPassword(String password) {
 		this.password = password;
 	}
}