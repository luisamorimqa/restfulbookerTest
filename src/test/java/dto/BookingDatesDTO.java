package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDatesDTO {

    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;

    public void setCheckin(String value){
        this.checkin = value;
    }

    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckout(String value) {
        this.checkout = value;
    }

    public String getCheckout() {
        return this.checkout;
    }
}
