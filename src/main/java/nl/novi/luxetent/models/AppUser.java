package nl.novi.luxetent.models;

import javax.persistence.*;

@Entity
@Table
public class AppUser {
    @Id
    @SequenceGenerator(
            name = "appUser_sequence",
            sequenceName = "appUser_sequence",
            allocationSize = 1
    )


   @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "appUser_sequence"
   )


    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password_encrypted;


    public AppUser() {

    }

    public AppUser(Long id, String name, String email, String phoneNumber, String password_encrypted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password_encrypted = password_encrypted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword_encrypted() {
        return password_encrypted;
    }

    public void setPassword_encrypted(String password_encrypted) {
        this.password_encrypted = password_encrypted;
    }
}
