package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.booker.BookerApi;
import ge.tbc.testautomation.data.model.restfulbooker.requests.*;
import ge.tbc.testautomation.data.model.restfulbooker.responses.AuthResponse;
import ge.tbc.testautomation.data.model.restfulbooker.responses.CreateBookingResponse;

public class BookerSteps {

    private final BookerApi api = new BookerApi();
    private String token;


    public void generateToken() {
        AuthResponse response = api.createToken(
                AuthRequest.builder()
                        .username("admin")
                        .password("password123")
                        .build()
        );

        token = response.getToken();
    }

    public String getToken() {
        return token;
    }


    public int createBooking() {

        CreateBookingResponse response = api.createBooking(
                UpdateBookingRequest.builder()
                        .firstname("Temp")
                        .lastname("User")
                        .totalprice(100)
                        .depositpaid(true)
                        .bookingdates(
                                BookingDates.builder()
                                        .checkin("2026-02-12")
                                        .checkout("2026-02-15")
                                        .build()
                        )
                        .additionalneeds("None")
                        .build()
        );

        return response.getBookingId();
    }


    public UpdateBookingRequest updateBooking(int bookingId) {

        UpdateBookingRequest request = UpdateBookingRequest.builder()
                .firstname("Tamar")
                .lastname("Kilasonia")
                .totalprice(999)
                .depositpaid(true)
                .bookingdates(
                        BookingDates.builder()
                                .checkin("2026-02-12")
                                .checkout("2026-02-20")
                                .build()
                )
                .additionalneeds("Breakfast")
                .saleprice(111)
                .passportNo("AA123")
                .build();

        return api.updateBooking(bookingId, token, request);
    }
}
