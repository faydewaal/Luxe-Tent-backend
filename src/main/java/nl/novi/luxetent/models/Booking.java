package nl.novi.luxetent.models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    private Date dateFrom;
    private Date dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tent_id")
    private Tent tent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tent getTent() {
        return tent;
    }

    public void setTent(Tent tent) {
        this.tent = tent;
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

}
