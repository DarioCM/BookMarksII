package dev.dario.bookmarks.controller;


import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.shaded.org.hamcrest.CoreMatchers;
import org.testcontainers.utility.TestcontainersConfiguration;

//
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

//integration test
@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookmarkControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
        RestAssured.port = port;
    }

    @Test
    void shouldGetBookmarkById(){
        given()
                .when()
                .get("/api/bookmarks/1")
                .then()
                .statusCode(200);
    }



}
