package nl.novi.luxetent.models;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Tent {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1003"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    private Long tentId;

    private String title;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;
    private String street;
    private String houseNumber;
    private String city;
    private String province;

    @OneToOne
    FileUploadResponse file;

    public Tent() {
    }

    public Tent(Long tentId, String title, String description, float pricePerNight, int maxNumberOfPersons, String street, String houseNumber, String city, String province, FileUploadResponse file) {
        this.tentId = tentId;
        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.province = province;
        this.file = file;
    }

    public Long getTentId() {
        return tentId;
    }

    public void setTentId(Long tentId) {
        this.tentId = tentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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
}
