package nl.novi.luxetent.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    private Long id;
    private String comment;
    private int rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tent_id")
    private Tent tent;

    public Review() {
    }

    public Review(Long id, String comment, int rating, Tent tent) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.tent = tent;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Tent getTent() {
        return tent;
    }

    public void setTent(Tent tent) {
        this.tent = tent;
    }
}
