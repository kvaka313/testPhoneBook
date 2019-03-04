package ua.galkin.dataservices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.galkin.dao.UserDao;
import ua.galkin.entities.User;
import ua.galkin.exceptions.UserAlreadyException;

import javax.transaction.Transactional;

@Slf4j
@Service
public class DataRegistrationService {

    private UserDao userDao;

    public DataRegistrationService(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    public void saveUser(User user){
      log.debug(String.format("Try to save user with login %s", user.getLogin()));
      userDao.findUserByLogin(user.getLogin()).ifPresent((u) -> {
          log.warn(String.format("User with login %s already exists", u.getLogin()));
          throw new UserAlreadyException(String.format("User with login %s already exists", u.getLogin()));
      });

      final User createdUser = userDao.saveUser(user);
      log.info(String.format("User with login %s has been created", createdUser.getLogin()));
    }


}
