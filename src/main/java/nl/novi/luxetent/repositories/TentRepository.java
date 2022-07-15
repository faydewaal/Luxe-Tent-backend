package nl.novi.luxetent.repositories;

import nl.novi.luxetent.models.Tent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TentRepository extends JpaRepository<Tent, Long> {
    List<Tent> findAllTentsByTitleEqualsIgnoreCase(String title);
}
