package csv302;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GradeApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getAllPosts() {

        given()

                .when()

                .get("/posts")

                .then()

                .statusCode(200)

                .body("size()", greaterThan(0));

    }

    @Test
    public void getSinglePost() {

        given()

                .when()

                .get("/posts/1")

                .then()

                .statusCode(200)

                .body("id", equalTo(1))
                .body("title", not(emptyString()));

    }

    @Test
    public void createPost() {

        HashMap<String,Object> body =
                new HashMap<>();

        body.put(
                "title",
                "Automation Test"
        );

        body.put(
                "body",
                "REST Assured"
        );

        body.put(
                "userId",
                1
        );

        given()

                .contentType("application/json")

                .body(body)

                .when()

                .post("/posts")

                .then()

                .statusCode(201)

                .body(
                        "title",
                        equalTo(
                                "Automation Test"
                        )
                );

    }

   @Test
   public void invalidPost() {

       given()

               .when()

               .get("/posts/99999")

               .then()

               .statusCode(404);

   }

   @Test
   public void deletePost() {

       given()

               .when()

               .delete("/posts/1")

               .then()

               .statusCode(200);

   }

}