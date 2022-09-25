package nl.novi.luxetent.repositories;


import nl.novi.luxetent.models.TentOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TentOptionRepository extends JpaRepository<TentOptions, Long> {
}
