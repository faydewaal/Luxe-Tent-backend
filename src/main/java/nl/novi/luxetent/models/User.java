package nl.novi.luxetent.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 155)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String apikey;

    @Column
    private String email;


    @OneToMany(
            targetEntity = Tent.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Tent> tent = new ArrayList<>();

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();
    
    @OneToMany
    private List<Booking> Bookings;

    public List<Booking> getBookings() {
		return Bookings;
	}

	public void setBookings(List<Booking> bookings) {
		Bookings = bookings;
	}

	public User() {
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() { 
    	return enabled;}
    
    public void setEnabled(boolean enabled) { 
    	this.enabled = enabled; }
    
    public String getApikey() { 
    	return apikey; }
    
    public void setApikey(String apikey) { 
    	this.apikey = apikey; }
    
    public String getEmail() { 
    	return email; }
    
    public void setEmail(String email) { 
    	this.email = email;}
    
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public List<Tent> getTent() {
        return tent;
    }

    public void setTent(List<Tent> tent) {
        this.tent = tent;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

}
