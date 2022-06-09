package nl.novi.luxetent.tent;


import javax.persistence.*;

@Entity
@Table
public class Tent {
    @Id
    @SequenceGenerator(
            name = "tent_sequence",
            sequenceName = "tent_sequence",
            allocationSize = 1
    )

    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "tent_sequence"
    )

    private long id;
    private String title;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;

    public Tent() {

    }

    public Tent(long id, String title, String description, float pricePerNight, int maxNumberOfPersons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
    }

    public Tent(String title, String description, float pricePerNight, int maxNumberOfPersons) {
        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Tent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", maxNumberOfPersons=" + maxNumberOfPersons +
                '}';
    }
}
