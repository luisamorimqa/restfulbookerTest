package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDTO {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("totalprice")
    private int totalprice;

    @JsonProperty("depositpaid")
    private boolean depositPaid;

    @JsonProperty("bookingdates")
    private BookingDatesDTO bookingDates;

    @JsonProperty("additionalneeds")
    private String additionalneeds;

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String value) {
        this.lastname = value;
    }

    public String getLastname() {
        return  this.lastname;
    }

    public void setTotalprice(int value) {
        this.totalprice = value;
    }

    public int getTotalprice() {
        return this.totalprice;
    }

    public void setDepositPaid(boolean value) {
        this.depositPaid = value;
    }

    public boolean getDepositPaid() {
        return this.depositPaid;
    }

    public void setBookingDates(BookingDatesDTO value) {
        this.bookingDates = value;
    }

    public BookingDatesDTO getBookingDates() {
        return this.bookingDates;
    }

    public void setAdditionalneeds(String value) {
        this.additionalneeds = value;
    }

    public String getAdditionalneeds() {
        return this.additionalneeds;
    }
}