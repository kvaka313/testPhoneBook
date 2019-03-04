package ua.galkin.dao;

import ua.galkin.entities.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findUserByLogin(String login);

    User saveUser(User user);
}
