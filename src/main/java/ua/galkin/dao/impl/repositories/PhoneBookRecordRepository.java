package ua.galkin.dao.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.galkin.entities.PhoneBookRecord;

import java.util.List;
import java.util.Optional;

public interface PhoneBookRecordRepository extends JpaRepository<PhoneBookRecord, Long> {
    List<PhoneBookRecord> findByUser_Login(String login);

    List<PhoneBookRecord> findByMobilePhoneContainingAndUser_Login(String phone, String login);

    List<PhoneBookRecord> findBySurenameAndUser_Login(String surename, String login);

    List<PhoneBookRecord>  findByNameAndUser_Login(String name, String login);

    List<PhoneBookRecord> findBySurenameAndMobilePhoneContainingAndUser_Login(String surename, String phone, String login);

    List<PhoneBookRecord> findByNameAndMobilePhoneContainingAndUser_Login(String name, String phone, String login);

    List<PhoneBookRecord> findByNameAndSurenameAndUser_Login(String name, String surename, String login);

    List<PhoneBookRecord> findByNameAndSurenameAndMobilePhoneAndUser_Login(String name, String surename, String phone, String login);

    Optional<PhoneBookRecord> findByIdAndUser_Login(Long id, String login);

}
