package nl.novi.luxetent.repositories;

import nl.novi.luxetent.models.Tent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TentRepository extends JpaRepository<Tent, Long> {

}
