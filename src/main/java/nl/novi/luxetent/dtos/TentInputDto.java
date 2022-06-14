package nl.novi.luxetent.dtos;

public class TentInputDto {
    private String name;
    private String description;
    private float pricePerNight;
    private int maxNumberOfPersons;

    public TentInputDto(String name, String description, float pricePerNight, int maxNumberOfPersons) {
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.maxNumberOfPersons = maxNumberOfPersons;
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
