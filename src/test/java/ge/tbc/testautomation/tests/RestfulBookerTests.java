package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.api.booker.BookerApi;
import ge.tbc.testautomation.config.BaseTest;
import ge.tbc.testautomation.data.model.restfulbooker.requests.*;
import ge.tbc.testautomation.data.model.restfulbooker.responses.AuthResponse;
import ge.tbc.testautomation.data.model.restfulbooker.responses.CreateBookingResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestfulBookerTests extends BaseTest {

    private final BookerApi api = new BookerApi();
    private String token;

    @BeforeClass
    public void createToken() {
        AuthResponse auth = api.createToken(AuthRequest.builder()
                .username("admin")
                .password("password123")
                .build());

        Assert.assertNotNull(auth.getToken());
        token = auth.getToken();
    }

    @Test
    public void updateBooking_shouldValidateFields() {


        CreateBookingResponse created = api.createBooking(UpdateBookingRequest.builder()
                .firstname("Temp")
                .lastname("User")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin("2026-02-12")
                        .checkout("2026-02-13")
                        .build())
                .additionalneeds("None")
                .build());

        int bookingId = created.getBookingId();
        Assert.assertTrue(bookingId > 0);


        UpdateBookingRequest updateReq = UpdateBookingRequest.builder()
                .firstname("Tamar")
                .lastname("K")
                .totalprice(999)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin("2026-02-12")
                        .checkout("2026-02-20")
                        .build())
                .additionalneeds("Breakfast")
                .saleprice(123)
                .passportNo("AA12345")
                .build();

        UpdateBookingRequest updated = api.updateBooking(bookingId, token, updateReq);


        Assert.assertEquals(updated.getFirstname(), updateReq.getFirstname());
        Assert.assertEquals(updated.getLastname(), updateReq.getLastname());
        Assert.assertEquals(updated.getTotalprice(), updateReq.getTotalprice());
        Assert.assertEquals(updated.getDepositpaid(), updateReq.getDepositpaid());
        Assert.assertEquals(updated.getAdditionalneeds(), updateReq.getAdditionalneeds());
        Assert.assertEquals(updated.getBookingdates().getCheckin(), updateReq.getBookingdates().getCheckin());
        Assert.assertEquals(updated.getBookingdates().getCheckout(), updateReq.getBookingdates().getCheckout());
    }
}
