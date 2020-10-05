package com.ronaldo.softplan.api.v1.dto.people;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PeopleCreateDto {

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.name}")
    private String name;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.gender}")
    private String gender;

    @NotNull
    @NotEmpty
    @Email
    @ApiModelProperty(value = "${people.create.email}")
    private String email;

    @NotNull
    @ApiModelProperty(value = "${people.create.birthdate}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.placeOfBirth}")
    private String placeOfBirth;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.citizenship}")
    private String citizenship;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.federalIdentification}")
    private String federalIdentification;

    public String getName() {
        return name;
    }

    public PeopleCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PeopleCreateDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PeopleCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public PeopleCreateDto setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public PeopleCreateDto setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public PeopleCreateDto setCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public PeopleCreateDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }
}
