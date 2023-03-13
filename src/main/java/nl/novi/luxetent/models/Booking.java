package nl.novi.luxetent.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    private Date dateFrom;
    private Date dateTo;
    
 
    @OneToMany
    private List<TentOptions> tentOptions;

	@OneToMany
    private List<Review> reviews;
    
    public Booking() {
    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public List<TentOptions> getTentOptions() {
		return tentOptions;
	}

	public void setTentOptions(List<TentOptions> tentOptions) {
		this.tentOptions = tentOptions;
	}
    

}
