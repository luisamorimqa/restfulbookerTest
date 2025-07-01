package endpoint;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingEndpoint {

    private final String BASE_URL = "https://restful-booker.herokuapp.com";

    public void getAllBookings() {

        RestAssured.baseURI = BASE_URL;

        given()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .when()
                .get("/booking")
                .then()
                .log().all()
                .statusCode(200)
        ;
    }

    public void getAnInexistentBooking() {

        RestAssured.baseURI = BASE_URL;
        String bookingId = "99999";

        given()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(404)
                .body(equalTo("Not Found"))
        ;

    }


}