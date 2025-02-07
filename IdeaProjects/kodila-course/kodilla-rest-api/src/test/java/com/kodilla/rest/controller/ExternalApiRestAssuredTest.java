package com.kodilla.rest.controller;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ExternalApiRestAssuredTest {

    @Test
    void testGetPostShouldReturnStatus200AndValidateResponse() {
        given().
                header("Content-Type", "application/json").
                when().
                get("https://jsonplaceholder.typicode.com/posts/1").
                then().
                statusCode(200).
                body("userId", equalTo(1)).
                body("id", equalTo(1)).
                body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).
                body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")).
                log().all();
    }

    @Test
    void testUpdatePostShouldReturnStatus200AndValidateUpdatedResponse() {
        Map<String, Object> updatedPostData = new HashMap<>();
        updatedPostData.put("id", 1);
        updatedPostData.put("title", "Updated title");
        updatedPostData.put("body", "This is the updated body text of the post.");

        given().
                header("Content-Type", "application/json").
                body(updatedPostData).
                when().
                put("https://jsonplaceholder.typicode.com/posts/1").
                then().
                statusCode(200).
                body("id", equalTo(1)).
                body("title", equalTo("Updated title")).
                body("body", equalTo("This is the updated body text of the post."))
                .log().all();
    }
}
