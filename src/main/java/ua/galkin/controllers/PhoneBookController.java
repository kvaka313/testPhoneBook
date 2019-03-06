package ua.galkin.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ua.galkin.dto.PhoneBookRecordDto;
import ua.galkin.services.PhoneBookService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class PhoneBookController {

    private PhoneBookService phoneBookService;

    public PhoneBookController(PhoneBookService phoneBookService){
        this.phoneBookService = phoneBookService;
    }

    @GetMapping
    public List<PhoneBookRecordDto> getPhoneBookRecords(@RequestParam(value = "name", required = false) String name,
                                                        @RequestParam(value = "surename", required = false) String surename,
                                                        @RequestParam(value = "phone", required = false) String phone){
        return phoneBookService.getBookPhoneRecords(getUserLogin(), name, surename, phone);

    }

    @PostMapping
    public void createBookPhoneRecord(@Valid @RequestBody PhoneBookRecordDto phoneBookRecordDto){
        phoneBookService.createRecord(getUserLogin(), phoneBookRecordDto);
    }

    @PutMapping(value = "/{recordId}")
    public void changePhoneRecord(@PathParam("recordId") String recordId,
                                  @RequestBody PhoneBookRecordDto phoneBookRecordDto){
        phoneBookService.updateRecord(getUserLogin(), recordId, phoneBookRecordDto);
    }

    @DeleteMapping(value = "/{recordId}")
    public void deletePhoneRecord(@PathParam("recordId") String recordId){
        phoneBookService.deleteRecord(getUserLogin(), recordId);
    }

    private String getUserLogin(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        return userDetails.getUsername();
    }

}
