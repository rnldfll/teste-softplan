package com.ronaldo.softplan.api.v1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ronaldo.softplan.AbstractTestController;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateResponseDto;

public class PeopleControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() {
        PeopleCreateDto peopleCreateDto = createPeopleDto();

        PeopleCreateResponseDto peopleCreateResponseDto = createAndReturnResponseDto(peopleCreateDto);

        assertCreatedPeople(peopleCreateDto, peopleCreateResponseDto);
    }

    @Test
    public void createWithInvalidFederalIdentification() {
        PeopleCreateDto peopleCreateDto = createPeopleDto();

        peopleCreateDto.setFederalIdentification("test");

        given()
                .header("Content-Type", "application/json")
                .body(peopleCreateDto)
                .post(PEOPLE_RESOURCE)
                .then()
                .statusCode(400)
                .body("message", equalTo("O CPF test informado é inválido"));
    }


    private void assertCreatedPeople(PeopleCreateDto peopleCreateDto, PeopleCreateResponseDto peopleCreateResponseDto) {
        Assert.assertNotNull(peopleCreateResponseDto.getId());

        Assert.assertEquals(peopleCreateDto.getName(), peopleCreateResponseDto.getName());
        Assert.assertEquals(peopleCreateDto.getFederalIdentification(), peopleCreateResponseDto.getFederalIdentification());
        Assert.assertEquals(String.valueOf(peopleCreateDto.getBirthdate()), peopleCreateResponseDto.getBirthdate());
        Assert.assertEquals(peopleCreateDto.getCitizenship(), peopleCreateResponseDto.getCitizenship());
        Assert.assertEquals(peopleCreateDto.getEmail(), peopleCreateResponseDto.getEmail());
        Assert.assertEquals(peopleCreateDto.getGender(), peopleCreateResponseDto.getGender());
    }

    private PeopleCreateDto createPeopleDto() {
        return new PeopleCreateDto()
                .setName("John Doe")
                .setBirthdate(LocalDate.now())
                .setCitizenship("Lorem Ipsum")
                .setEmail("johndoe@gmail.com")
                .setFederalIdentification("752.574.700-80")
                .setGender("male")
                .setPlaceOfBirth("Et mus");
    }

    private PeopleCreateResponseDto createAndReturnResponseDto(PeopleCreateDto peopleCreateDto) {
        return given()
                .header("Content-Type", "application/json")
                .body(peopleCreateDto)
                .post(PEOPLE_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(PeopleCreateResponseDto.class);
    }
}
