package endpoint;

import dataTest.BookingDataTest;
import dto.BookingDTO;
import io.restassured.RestAssured;
import utils.SharedData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.notNullValue;
import static utils.Token.getToken;

public class BookingEndpoint {

    private final String BASE_URL = "https://restful-booker.herokuapp.com";


    public String newBooking() {

        RestAssured.baseURI = BASE_URL;
        BookingDTO bookingDTO = BookingDataTest.setValue();

        String bookingId =
        given()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .body(bookingDTO)
                .post("/booking")
                .then()
                .log().all()
                .extract().path("bookingid")
                .toString();

        return bookingId;
    }

    public void postNewBooking() {

        RestAssured.baseURI = BASE_URL;
        BookingDTO bookingDTO = BookingDataTest.setValue();

        given()
                .header("Content-type", "application/json")
                .body(bookingDTO)
                .log().all()
                .post("/booking")
                .then()
                .log().all()
                .body("booking.firstname", equalTo(bookingDTO.getFirstname()))
                .body("booking.lastname", equalTo(bookingDTO.getLastname()))
                .statusCode(200)
        ;
    }

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
                .body(notNullValue());
    }

    public void getABookingById() {

        RestAssured.baseURI = BASE_URL;
        String bookingId = newBooking();
        BookingDTO bookingDTO = SharedData.get("bookingDTO");

        given()
                .header("Content-type", "application/json")
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo(bookingDTO.getFirstname()))
                .body("lastname", equalTo(bookingDTO.getLastname()))
                .body("totalprice", equalTo(bookingDTO.getTotalprice()))
                .body("depositpaid", equalTo(bookingDTO.getDepositPaid()))
                .body("bookingdates.checkin", equalTo(bookingDTO.getBookingDates().getCheckin()))
                .body("bookingdates.checkout", equalTo(bookingDTO.getBookingDates().getCheckout()))
                .body("additionalneeds", equalTo(bookingDTO.getAdditionalneeds()));
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

    public void deleteBooking() {

        RestAssured.baseURI = BASE_URL;
        String bookingId = newBooking();

        given()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
                .header("Cookie", "token=" + getToken())
                .log().all()
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201)
                .body(equalTo("Created"));

        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(404)
                .body(equalTo("Not Found"));
    }
}