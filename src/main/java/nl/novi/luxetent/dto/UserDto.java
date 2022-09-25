package nl.novi.luxetent.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.luxetent.models.Authority;
import nl.novi.luxetent.models.Tent;

import java.util.Set;

public class UserDto {

    public String username;
    public Boolean enabled;
    public String apikey;
    public String email;
    @JsonSerialize
    public Set<Authority> authorities;
    public String password;
    public Tent tent;

    public Tent getTent() {
        return tent;
    }

    public void setTent(Tent tent) {
        this.tent = tent;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}

