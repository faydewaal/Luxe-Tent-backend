package nl.novi.luxetent.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    private Long id;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tent_id")
    private Tent tent;

    public Review() {
    }

    public Review(Long id, String comment) {
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
