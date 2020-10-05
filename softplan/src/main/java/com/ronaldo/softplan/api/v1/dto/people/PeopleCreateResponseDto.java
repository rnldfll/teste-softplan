package com.ronaldo.softplan.api.v1.dto.people;

import io.swagger.annotations.ApiModelProperty;

public class PeopleCreateResponseDto {

    @ApiModelProperty(value = "${people.create.id}")
    private String id;

    @ApiModelProperty(value = "${people.create.name}")
    private String name;

    @ApiModelProperty(value = "${people.create.gender}")
    private String gender;

    @ApiModelProperty(value = "${people.create.email}")
    private String email;

    @ApiModelProperty(value = "${people.create.birthdate}")
    private String birthdate;

    @ApiModelProperty(value = "${people.create.placeOfBirth}")
    private String placeOfBirth;

    @ApiModelProperty(value = "${people.create.citizenship}")
    private String citizenship;

    @ApiModelProperty(value = "${people.create.federalIdentification}")
    private String federalIdentification;

    @ApiModelProperty(value = "${people.create.createDate}")
    private String createDate;

    @ApiModelProperty(value = "${people.create.lastUpdate}")
    private String lastUpdate;

    public String getId() {
        return id;
    }

    public PeopleCreateResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PeopleCreateResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PeopleCreateResponseDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PeopleCreateResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public PeopleCreateResponseDto setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public PeopleCreateResponseDto setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public PeopleCreateResponseDto setCitizenship(String citizenship) {
        this.citizenship = citizenship;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public PeopleCreateResponseDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public PeopleCreateResponseDto setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public PeopleCreateResponseDto setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}
