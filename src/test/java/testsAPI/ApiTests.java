package testsAPI;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import models.UserRegResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.User;
import models.UserReg;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static specs.Specs.REQ_SPEQ;

@DisplayName("API tests reqres.in")
public class ApiTests {

    @BeforeAll
    public static void setFilter(){ RestAssured.filters(withCustomTemplates()); }

    @DisplayName("Get existent user")
    @Owner("Daniil Borisevich")
    @Test
    public void getUserTest(){
        given()
                .spec(REQ_SPEQ)
                .when().get("/users/2")
                .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/userGetSchema.json"));
    }

    @DisplayName("Get non-existent user")
    @Owner("Daniil Borisevich")
    @Test
    public void getNonExistentUserTest(){
        given()
                .spec(REQ_SPEQ)
                .when().get("/users/23")
                .then()
                .statusCode(404);
    }

    @DisplayName("Get list of users")
    @Owner("Daniil Borisevich")
    @Test
    public void getListOfUsers(){
        given()
                .spec(REQ_SPEQ)
                .when().get("/users?page=2")
                .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/usersGetSchema.json"));
    }

    @DisplayName("Create user")
    @Owner("Daniil Borisevich")
    @Test
    public void createUser(){
        Faker faker = new Faker();
        User user  = User.builder().name(faker.name().firstName())
                .job(faker.job().position()).build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().post("/users")
                .then()
                .statusCode(201)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/userCreateResponseSchema.json"));
    }

    @DisplayName("Update user with PUT request")
    @Owner("Daniil Borisevich")
    @Test
    public void updateUserWithPutTest(){
        Faker faker = new Faker();
        User user = User.builder().name(faker.name().firstName())
                .job(faker.job().position()).build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().put("/users/2")
                .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/userUpdateSchema.json"));
    }

    @DisplayName("Update user with PATCH request")
    @Owner("Daniil Borisevich")
    @Test
    public void updateUserWithPostTest(){
        Faker faker = new Faker();
        User user = User.builder().name(faker.name().firstName())
                .job(faker.job().position()).build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().patch("/users/2")
                .then()
                .statusCode(200)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/userUpdateSchema.json"));
    }

    @DisplayName("Delete user")
    @Owner("Daniil Borisevich")
    @Test
    public void deleteUserTest(){
        Faker faker = new Faker();
        User user = User.builder().name(faker.name().firstName())
                .job(faker.job().position()).build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().delete("/users/2")
                .then()
                .statusCode(204);
    }


    @DisplayName("Success user registration")
    @Owner("Daniil Borisevich")
    @Test
    public void registerSuccessful(){
        UserReg user = UserReg.builder().email("eve.holt@reqres.in")
                .password("pistol").build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().post("/register")
                .then()
                .statusCode(200)
                .extract().as(UserRegResult.class);
    }

    @DisplayName("Non-success user registration")
    @Owner("Daniil Borisevich")
    @Test
    public void registerNonSuccessful(){
        UserReg user = UserReg.builder().email("sydney@fife").build();

        given()
                .spec(REQ_SPEQ)
                .body(user)
                .when().post("/register")
                .then()
                .statusCode(400)
                .assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/registrationErrorSchema.json"));
    }

}
