//package nl.novi.luxetent.user;
//
//import javax.persistence.*;
//
//@Entity
//@Table
//public class User {
//    @Id
//    @SequenceGenerator(
//            name = "user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
//
//    @GeneratedValue (
//        strategy = GenerationType.SEQUENCE,
//        generator = "user_sequence"
//    )
//    private Long id;
//    private String name;
//    private String email;
//    private String phoneNumber;
//    private String password_encrypted;
//
//    public User() {
//
//    }
//
//    public User(Long id, String name, String email, String phoneNumber, String password_encrypted) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password_encrypted = password_encrypted;
//    }
//
//    public User(String name, String email, String phoneNumber, String password_encrypted) {
//        this.name = name;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password_encrypted = password_encrypted;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getPassword_encrypted() {
//        return password_encrypted;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setPassword_encrypted(String password_encrypted) {
//        this.password_encrypted = password_encrypted;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", password_encrypted='" + password_encrypted + '\'' +
//                '}';
//    }
//}
