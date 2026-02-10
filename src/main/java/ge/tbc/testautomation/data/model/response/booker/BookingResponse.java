package ge.tbc.testautomation.data.model.response.booker;

import ge.tbc.testautomation.data.model.request.booker.BookingDates;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponse {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}