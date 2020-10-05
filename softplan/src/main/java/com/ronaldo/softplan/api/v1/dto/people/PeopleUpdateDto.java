package com.ronaldo.softplan.api.v1.dto.people;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PeopleUpdateDto {

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "${people.create.id}")
    private String id;

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

    public String getId() {
        return id;
    }

    public PeopleUpdateDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PeopleUpdateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PeopleUpdateDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PeopleUpdateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public PeopleUpdateDto setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public PeopleUpdateDto setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public PeopleUpdateDto setCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public PeopleUpdateDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }
}
