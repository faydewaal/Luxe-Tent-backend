package nl.novi.luxetent.repositories;

import nl.novi.luxetent.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
