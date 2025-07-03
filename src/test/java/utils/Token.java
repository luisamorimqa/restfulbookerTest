package utils;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Token {

    public static String getToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        String username = ConfigReader.getProperty("api.username");
        String password = ConfigReader.getProperty("api.password");

        return
        given()
                .header("Content-type", "application/json")
                .body("{\n" +
                        "\"username\" : " + username + ",\n" +
                        "\"password\" : " + password + "\n" +
                        "}")
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().path("token");
    }
}
