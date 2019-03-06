package ua.galkin.dao.impl;

import org.springframework.stereotype.Component;
import ua.galkin.dao.PhoneBookRecordDao;
import ua.galkin.dao.impl.repositories.PhoneBookRecordRepository;
import ua.galkin.entities.PhoneBookRecord;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneBookRecordDaoDatabaseImpl implements PhoneBookRecordDao {

    private PhoneBookRecordRepository phoneBookRecordRepository;

    public PhoneBookRecordDaoDatabaseImpl(PhoneBookRecordRepository phoneBookRecordRepository){
        this.phoneBookRecordRepository = phoneBookRecordRepository;
    }


    @Override
    public List<PhoneBookRecord> getAll(String login) {
        return phoneBookRecordRepository.findByUser_Login(login);
    }

    @Override
    public List<PhoneBookRecord> findByPhone( String phone, String login) {
        return phoneBookRecordRepository.findByMobilePhoneContainingAndUser_Login(phone, login);
    }

    @Override
    public List<PhoneBookRecord> findBySurename(String surename, String login) {
        return phoneBookRecordRepository.findBySurenameAndUser_Login(surename, login);
    }

    @Override
    public List<PhoneBookRecord> findByName(String name, String login) {
        return phoneBookRecordRepository.findByNameAndUser_Login(name, login);
    }

    @Override
    public List<PhoneBookRecord> findBySurenameAndPhone(String surename, String phone, String login) {
        return phoneBookRecordRepository.findBySurenameAndMobilePhoneContainingAndUser_Login(surename, phone, login);
    }

    @Override
    public List<PhoneBookRecord> findByNameAndPhone(String name, String phone, String login) {
        return phoneBookRecordRepository.findByNameAndMobilePhoneContainingAndUser_Login(name, phone, login);
    }

    @Override
    public List<PhoneBookRecord> findByNameAndSurename(String name, String surename, String login) {
        return phoneBookRecordRepository.findByNameAndSurenameAndUser_Login(name, surename, login);
    }

    @Override
    public List<PhoneBookRecord> findByNameAndSurenameAndPhone(String name, String surename, String phone, String login) {
        return phoneBookRecordRepository.findByNameAndSurenameAndMobilePhoneAndUser_Login(name, surename, phone, login);
    }

    @Override
    public Optional<PhoneBookRecord> findByIdAndLogin(Long id, String login){
        return phoneBookRecordRepository.findByIdAndUser_Login(id, login);
    }

    @Override
    public void createRecord(PhoneBookRecord phoneBookRecord) {
        phoneBookRecordRepository.save(phoneBookRecord);
    }

    @Override
    public void updateRecord(PhoneBookRecord phoneBookRecord) {
        phoneBookRecordRepository.save(phoneBookRecord);
    }

    @Override
    public void deleteRecord(PhoneBookRecord phoneBookRecord) {
       phoneBookRecordRepository.delete(phoneBookRecord);
    }
}
