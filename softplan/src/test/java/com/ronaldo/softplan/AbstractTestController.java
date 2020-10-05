package com.ronaldo.softplan;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ronaldo.softplan.api.RestPath;
import com.ronaldo.softplan.repository.PeopleRepository;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class AbstractTestController {

    public static String API_V1;
    public static String PEOPLE_RESOURCE;

    @LocalServerPort
    public int randomPort;

    @Autowired
    private PeopleRepository peopleRepository;


    public void setup() throws Exception {
        RestAssured.port = randomPort;
        API_V1 = RestPath.BASE_PATH_V1;
        PEOPLE_RESOURCE = API_V1 + "/people";
    }

    public void delete() {
        peopleRepository.deleteAll();
    }
}
