package ge.tbc.testautomation.data.model.response.booker;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponse {

    private Integer bookingid;
    private BookingResponse booking;
}