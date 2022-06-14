package nl.novi.luxetent.models;
import javax.persistence.*;

@Entity
public class Tent {
    @Id
    @GeneratedValue
    Long id;

    private String name;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;

    public Tent() {}

    public Tent(long id, String title, String description, float pricePerNight, int maxNumberOfPersons) {
        this.id = id;
        this.name = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public int getMaxNumberOfPersons() {
        return maxNumberOfPersons;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String title) {
        this.name = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setMaxNumberOfPersons(int maxNumberOfPersons) {
        this.maxNumberOfPersons = maxNumberOfPersons;
    }
}
