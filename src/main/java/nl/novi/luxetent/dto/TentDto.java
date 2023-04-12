package nl.novi.luxetent.dto;

import java.util.List;

import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.models.TentOptions;

public class TentDto {
    public Long id;
    public String title;
    public String description;
    public float pricePerNight;
    public int maxNumberOfPersons;
    public String street;
    public String houseNumber;
    public String city;
    public String province;
	public FileUploadResponse file;
	public List<TentOptions> tentoptions;

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

	public List<TentOptions> getTentoptions() {
		return tentoptions;
	}

	public void setTentoptions(List<TentOptions> tentoptions) {
		this.tentoptions = tentoptions;
	}
	
	
    

}
