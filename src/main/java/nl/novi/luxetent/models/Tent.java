package nl.novi.luxetent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;


@Entity
public class Tent {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;
    private String street;
    private String houseNumber;
    private String city;
    private String province;

    public Tent() {
    }

    @OneToOne
    FileUploadResponse file;

    @OneToOne(mappedBy = "tent")
    User user;

    @OneToOne
    TentOptions tentOptions;

    @OneToMany(mappedBy = "tent")
    @JsonIgnore
    List<Booking> bookings;

    @OneToMany(mappedBy = "tent")
    @JsonIgnore
    List<Review> reviews;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxNumberOfPersons() {
        return maxNumberOfPersons;
    }

    public void setMaxNumberOfPersons(int maxNumberOfPersons) {
        this.maxNumberOfPersons = maxNumberOfPersons;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public TentOptions getTentOption() {
        return tentOptions;
    }

    public void setTentOption(TentOptions tentOptions) {
        this.tentOptions = tentOptions;
    }
}
