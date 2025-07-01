package tests;

import endpoint.BookingEndpoint;
import org.junit.jupiter.api.Test;

public class BookingTests {

    BookingEndpoint bookingEndpoit = new BookingEndpoint();

    @Test
    public void testGetAllBookings() {
        bookingEndpoit.getAllBookings();
    }

    @Test
    public void testGetAnInexistentBooking() {
        bookingEndpoit.getAnInexistentBooking();
    }
}