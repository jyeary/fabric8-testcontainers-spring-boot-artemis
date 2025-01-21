package com.example.spring.fabric8.tc;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.hamcrest.Matchers;
import org.testcontainers.utility.DockerImageName;

public class RestControllerIT {

    static GenericContainer<?> restContainer = new GenericContainer(DockerImageName.parse("fabric8-testcontainers-spring-boot:latest"))
            .withExposedPorts(8080);

    @BeforeAll
    static void beforeAll() {
        restContainer.start();
    }

    @AfterAll
    static void afterAll() {
        restContainer.stop();
    }

    @BeforeEach
    void beforeEach() {
        RestAssured.baseURI = "http://localhost:" + restContainer.getFirstMappedPort();
    }

    @Test
    void checkServerResponse() {
        String responseBody
                = given()
                        .when()
                        .get("/")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        MatcherAssert.assertThat(responseBody, Matchers.equalToIgnoringCase("<h1>Greetings from Spring Boot (Powered by Fabric8)!!</h1>"));
    }

}
