package ua.galkin.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "phone_book_records")
public class PhoneBookRecord {
    @Id
    @SequenceGenerator(name = "RECORD_ID_GENERATOR", sequenceName = "RECORD_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECORD_ID_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "surename", nullable = false)
    private String surename;

    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @Column(name = "home_phone")
    private String home_phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
