package nl.novi.luxetent.models;

import javax.persistence.*;

@Entity
public class TentOptions {
    @Id
    private Long id;
    private String optionName;
    private Float price;

    public TentOptions() {
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
