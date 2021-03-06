package nl.novi.luxetent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Tent {
    @Id
    @GeneratedValue
    private Long Id;

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

    public Tent(Long id, String title, String description, float pricePerNight, int maxNumberOfPersons, String street, String houseNumber, String city, String province, FileUploadResponse file, List<Booking> bookings, List<Review> reviews, List<TentOption> tentOptions) {
        Id = id;
        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.province = province;
        this.file = file;
        this.bookings = bookings;
        this.reviews = reviews;
        this.tentOptions = tentOptions;
    }

    @OneToOne
    FileUploadResponse file;

    @OneToMany(mappedBy = "tent")
    @JsonIgnore
    List<Booking> bookings;

    @OneToMany(mappedBy = "tent")
    @JsonIgnore
    List<Review> reviews;

    @OneToMany(mappedBy = "tent")
    @JsonIgnore
    List<TentOption> tentOptions;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public List<TentOption> getTentOptions() {
        return tentOptions;
    }

    public void setTentOptions(List<TentOption> tentOptions) {
        this.tentOptions = tentOptions;
    }
}
