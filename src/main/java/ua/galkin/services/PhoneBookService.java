package ua.galkin.services;

import org.springframework.stereotype.Service;
import ua.galkin.converters.PhoneBookRecordConverter;
import ua.galkin.dataservices.PhoneBookRecordDataService;
import ua.galkin.dto.PhoneBookRecordDto;
import ua.galkin.exceptions.NullLoginException;

import java.util.List;

@Service
public class PhoneBookService {

    private PhoneBookRecordDataService phoneBookRecordDataService;

    public PhoneBookService(PhoneBookRecordDataService phoneBookRecordDataService){
        this.phoneBookRecordDataService = phoneBookRecordDataService;
    }

    public List<PhoneBookRecordDto> getBookPhoneRecords(String login, String name, String surename, String phone){
        if(login == null){
            throw new NullLoginException("Login is required.");
        }

        if(name == null && surename == null && phone == null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.getAll(login));
        }

        if(name == null && surename == null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findByPhone(login, phone));
        }

        if(name == null && phone == null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findBySurename(login, surename));
        }

        if(surename == null && phone ==null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findByName(login, name));
        }

        if(name == null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findBySurenameAndPhone(login, surename, phone));
        }

        if(surename == null){
           return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findByNameAndPhone(login, name, phone));
        }

        if(phone == null){
            return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findByNameAndSurename(login, name, surename));
        }

        return PhoneBookRecordConverter.INSTANCE.convertToListDto(phoneBookRecordDataService.findByNameAndSurenameAndPhone(login, name, surename, phone));
     }

     public void createRecord(String login, PhoneBookRecordDto phoneBookRecordDto){
        phoneBookRecordDataService.createRecord(login, PhoneBookRecordConverter.INSTANCE.convertToEntity(phoneBookRecordDto));
     }

     public void updateRecord(String login, String recordId, PhoneBookRecordDto phoneBookRecordDto){
        phoneBookRecordDataService.updateRecord(login, recordId, PhoneBookRecordConverter.INSTANCE.convertToEntity(phoneBookRecordDto));
     }

     public void deleteRecord(String login, String recordId){
        Long id = Long.parseLong(recordId);
        phoneBookRecordDataService.deleteRecord(login, id);
     }
}
