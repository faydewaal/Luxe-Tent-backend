package nl.novi.luxetent.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TentOption {
    @Id
    private Long id;
    private String optionName;
    private Float price;

    public TentOption() {
    }

    public TentOption(Long id, String optionName, Float price) {
        this.id = id;
        this.optionName = optionName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
