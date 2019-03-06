package ua.galkin.dataservices;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ua.galkin.converters.PhoneBookRecordConverter;
import ua.galkin.dao.PhoneBookRecordDao;
import ua.galkin.dao.UserDao;
import ua.galkin.entities.PhoneBookRecord;
import ua.galkin.entities.User;
import ua.galkin.exceptions.RecordNotFoundException;
import ua.galkin.exceptions.UserNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PhoneBookRecordDataService {

    private PhoneBookRecordDao phoneBookRecordDao;

    private UserDao userDao;

    public PhoneBookRecordDataService(PhoneBookRecordDao phoneBookRecordDao, UserDao userDao){
        this.phoneBookRecordDao = phoneBookRecordDao;
        this.userDao = userDao;
    }

    public List<PhoneBookRecord> getAll(String login){
        return phoneBookRecordDao.getAll(login);
    }

    public List<PhoneBookRecord> findByPhone(String login, String phone){
        return phoneBookRecordDao.findByPhone(phone, login);
    }

    public List<PhoneBookRecord> findBySurename(String login, String surename){
        return phoneBookRecordDao.findBySurename(surename, login);
    }

    public List<PhoneBookRecord> findByName(String login, String name){
        return phoneBookRecordDao.findByName(name, login);
    }

    public List<PhoneBookRecord> findBySurenameAndPhone(String login, String surename, String phone){
        return phoneBookRecordDao.findBySurenameAndPhone(surename, phone, login);
    }

    public List<PhoneBookRecord> findByNameAndPhone(String login, String name, String phone){
         return phoneBookRecordDao.findByNameAndPhone(name, phone, login);
    }

    public List<PhoneBookRecord> findByNameAndSurename(String login, String name, String surename){
        return phoneBookRecordDao.findByNameAndSurename(name, surename, login);
    }

    public List<PhoneBookRecord> findByNameAndSurenameAndPhone(String login, String name, String surename, String phone){
        return phoneBookRecordDao.findByNameAndSurenameAndPhone(name, surename, phone, login);
    }

    @Modifying
    @Transactional
    public void createRecord(String login, PhoneBookRecord phoneBookRecord){
        User user = userDao.findUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with login %s does not exist", login)));
        phoneBookRecord.setUser(user);
        phoneBookRecordDao.createRecord(phoneBookRecord);
    }

    @Modifying
    @Transactional
    public void updateRecord(String login, Long recordId, PhoneBookRecord phoneBookRecord){
        PhoneBookRecord currentPhoneBookRecord = phoneBookRecordDao.findByIdAndLogin(recordId, login)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Record with id %s does not find for user with login %s", recordId, login)));
        PhoneBookRecordConverter.INSTANCE.merge(phoneBookRecord, currentPhoneBookRecord);
        phoneBookRecordDao.updateRecord(currentPhoneBookRecord);
    }

    @Modifying
    @Transactional
    public void deleteRecord(String login, Long recordId){
        PhoneBookRecord phoneBookRecord = phoneBookRecordDao.findByIdAndLogin(recordId, login)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Record with id %s does not find for user with login %s", recordId, login)));
        phoneBookRecord.setUser(null);
        phoneBookRecordDao.deleteRecord(phoneBookRecord);
    }

}
