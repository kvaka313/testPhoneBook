package ua.galkin.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.galkin.converters.UserConverter;
import ua.galkin.dataservices.DataRegistrationService;
import ua.galkin.dto.UserDto;

@Service
public class RegistrationService {

    private PasswordEncoder passwordEncoder;

    private DataRegistrationService dataRegistrationService;

    public RegistrationService(DataRegistrationService dataRegistrationService, PasswordEncoder passwordEncoder){
        this.dataRegistrationService = dataRegistrationService;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrationUser(UserDto userDto){
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        dataRegistrationService.saveUser(UserConverter.INSTANCE.convertToEntity(userDto));
    }

}
