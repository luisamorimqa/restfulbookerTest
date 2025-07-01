package tests;

import endpoint.BookingEndpoint;
import org.junit.jupiter.api.Test;

public class BookingTests {

    BookingEndpoint bookingEndpoint = new BookingEndpoint();

    @Test
    public void testGetAllBookings() {
        bookingEndpoint.getAllBookings();
    }

    @Test
    public void testGetAnInexistentBooking() {
        bookingEndpoint.getAnInexistentBooking();
    }

    @Test
    public void testPostNewBooking() {
        bookingEndpoint.postNewBooking();
    }

    @Test
    public void testGetBookingById() {
        bookingEndpoint.getABookingById();
    }
}