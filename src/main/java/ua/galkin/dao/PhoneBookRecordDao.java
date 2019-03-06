package ua.galkin.dao;

import ua.galkin.entities.PhoneBookRecord;

import java.util.List;
import java.util.Optional;

public interface PhoneBookRecordDao {
    List<PhoneBookRecord> getAll(String login);

    List<PhoneBookRecord> findByPhone(String phon, String login);

    List<PhoneBookRecord> findBySurename(String surename, String login);

    List<PhoneBookRecord> findByName(String name, String login);

    List<PhoneBookRecord> findBySurenameAndPhone(String surename, String phone, String login);

    List<PhoneBookRecord> findByNameAndPhone(String name, String phone, String login);

    List<PhoneBookRecord> findByNameAndSurename(String name, String surename, String login);

    List<PhoneBookRecord> findByNameAndSurenameAndPhone(String name, String surename, String phone, String login);

    void createRecord(PhoneBookRecord phoneBookRecord);

    void updateRecord(PhoneBookRecord phoneBookRecord);

    void deleteRecord(PhoneBookRecord phoneBookRecord);

    Optional<PhoneBookRecord> findByIdAndLogin(Long id, String login);

}
