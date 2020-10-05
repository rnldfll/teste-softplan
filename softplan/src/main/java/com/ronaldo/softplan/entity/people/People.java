package com.ronaldo.softplan.entity.people;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class People {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "PLACE_OF_BIRTH")
    private String placeOfBirth;

    @Column(name = "CITIZENSHIP")
    private String citizenship;

    @Column(name = "FEDERAL_IDENTIFICATION", nullable = false)
    private String federalIdentification;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "LAST_UPDATE", nullable = false)
    private LocalDateTime lastUpdate;

    public String getId() {
        return id;
    }

    public People setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public People setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public People setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public People setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public People setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public People setCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public People setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public People setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public People setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
