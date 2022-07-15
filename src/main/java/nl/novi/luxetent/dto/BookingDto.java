package nl.novi.luxetent.dto;

import java.util.Date;

public class BookingDto {
    private Long id;
    private String comment;
    private Date dateFrom;
    private Date dateTo;

    public BookingDto() {
    }

    public BookingDto(Long id, String comment, Date dateFrom, Date dateTo) {
        this.id = id;
        this.comment = comment;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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
}
