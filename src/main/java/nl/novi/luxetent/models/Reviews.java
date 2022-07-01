package nl.novi.luxetent.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reviews {
    @Id
    private Long id;
    private String comment;

    public Reviews() {
    }

    public Reviews(Long id, String comment) {
        this.id = id;
        this.comment = comment;
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
}
