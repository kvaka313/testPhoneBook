package ua.galkin.dao.impl;

import org.springframework.stereotype.Component;
import ua.galkin.dao.UserDao;
import ua.galkin.dao.impl.repositories.UserRepository;
import ua.galkin.entities.User;

import java.util.Optional;

@Component
public class UserDaoDatabaseImpl implements UserDao {

    private UserRepository userRepository;

    public UserDaoDatabaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> saveUser(User user) {
        return Optional.of(userRepository.save(user));
    }
}
