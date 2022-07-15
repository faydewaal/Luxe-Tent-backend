package nl.novi.luxetent.repositories;


import nl.novi.luxetent.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
