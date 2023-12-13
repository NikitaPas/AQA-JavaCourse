package org.example;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @BeforeAll
    public static void setup(){
        baseURI = "https://postman-echo.com";
    }
    @Test
    public void getRequestTest(){
        given()
                .when()
                .get("/get?foo1=bar1")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1"));
    }
    @Test
    public void putRequestTest(){
        given()
                .body("testPut")
                .when()
                .post("/post")
                .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("data", equalTo("testPut"))
                .body("headers.isEmpty()", equalTo(false));
    }
}
