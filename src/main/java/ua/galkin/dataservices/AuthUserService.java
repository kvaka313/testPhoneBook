package ua.galkin.dataservices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.galkin.dao.UserDao;

@Slf4j
@Service
public class AuthUserService implements UserDetailsService {

    private UserDao userDao;

    public AuthUserService(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userDao.findUserByLogin(login).orElseThrow(()->{
            log.warn(String.format("User with login %s not found.", login));
            throw new UsernameNotFoundException(String.format("User with login %s not found.", login));});

    }

}
