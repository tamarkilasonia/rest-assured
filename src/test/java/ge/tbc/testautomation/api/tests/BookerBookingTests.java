package ge.tbc.testautomation.api.tests;

import ge.tbc.testautomation.data.model.request.booker.*;
import ge.tbc.testautomation.data.model.response.booker.BookingResponse;
import ge.tbc.testautomation.steps.BookerSteps;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookerBookingTests {

    private final BookerSteps steps = new BookerSteps();

    @Test
    public void testToken_Create_Get_PartialUpdate_Delete() {

        String token = steps.createToken(new TokenRequest("admin", "password123"));

        BookingRequest createReq = new BookingRequest(
                "John",
                "Doe",
                500,
                true,
                new BookingDates("2025-01-01", "2025-01-10"),
                "Breakfast"
        );

        int bookingId = steps.createBooking(createReq);

        BookingResponse created = steps.getBooking(bookingId);
        assertThat(created.getFirstname(), equalTo("John"));
        assertThat(created.getTotalprice(), equalTo(500));
        assertThat(created.getBookingdates().getCheckin(), equalTo("2025-01-01"));

        PartialUpdateBookingRequest updateReq = new PartialUpdateBookingRequest();
        updateReq.setFirstname("Updated");
        updateReq.setTotalprice(777);

        steps.partialUpdate(bookingId, token, updateReq);

        BookingResponse updated = steps.getBooking(bookingId);
        assertThat(updated.getFirstname(), equalTo("Updated"));
        assertThat(updated.getTotalprice(), equalTo(777));

        steps.deleteBooking(bookingId, token);


        steps.checkBookingDeleted(bookingId);
    }
}
