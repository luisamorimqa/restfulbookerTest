package dataTest;

import com.github.javafaker.Faker;
import dto.BookingDTO;
import dto.BookingDatesDTO;
import utils.SharedData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingDataTest {

    public static BookingDTO setValue() {

        Faker faker = new Faker();
        BookingDTO bookingDTO = new BookingDTO();
        BookingDatesDTO bookingDatesDTO = new BookingDatesDTO();
        int bookingDays = faker.number().numberBetween(2, 20);
        int dailyRate = faker.number().numberBetween(50, 500);

        LocalDate checkin = LocalDate.now().plusDays(faker.number().numberBetween(1, 30));
        LocalDate checkout = checkin.plusDays(bookingDays);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        bookingDatesDTO.setCheckin(checkin.format(formatter));
        bookingDatesDTO.setCheckout(checkout.format(formatter));

        bookingDTO.setFirstname(faker.name().firstName());
        bookingDTO.setLastname(faker.name().lastName());
        bookingDTO.setTotalprice(bookingDays * dailyRate);
        bookingDTO.setDepositPaid(faker.bool().bool());
        bookingDTO.setBookingDates(bookingDatesDTO);
        bookingDTO.setAdditionalneeds(faker.chuckNorris().fact());

        SharedData.set("bookingDTO", bookingDTO);
        return bookingDTO;
    }
}
