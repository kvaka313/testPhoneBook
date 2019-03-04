package ua.galkin.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.galkin.dto.UserDto;
import ua.galkin.services.RegistrationService;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }


    @PostMapping
    public void registration(@Valid @RequestBody UserDto userDto){
        registrationService.registrationUser(userDto);
    }
}
