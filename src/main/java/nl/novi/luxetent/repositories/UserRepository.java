package nl.novi.luxetent.repositories;

import nl.novi.luxetent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
