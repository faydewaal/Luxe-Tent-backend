package nl.novi.luxetent.dtos;

public class TentDto {
    private Long id;
    private String name;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;

    public TentDto() {
    }

    public TentDto(Long id, String name, String description, float pricePerNight, int maxNumberOfPersons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
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
}
