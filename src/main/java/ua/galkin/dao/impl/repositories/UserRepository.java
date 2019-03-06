package ua.galkin.dao.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.galkin.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
