package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.client.BookerAuthApi;
import ge.tbc.testautomation.api.client.BookerBookingApi;

import ge.tbc.testautomation.data.model.request.booker.BookingRequest;
import ge.tbc.testautomation.data.model.request.booker.PartialUpdateBookingRequest;
import ge.tbc.testautomation.data.model.request.booker.TokenRequest;

import ge.tbc.testautomation.data.model.response.booker.BookingResponse;
import ge.tbc.testautomation.data.model.response.booker.CreateBookingResponse;
import ge.tbc.testautomation.data.model.response.booker.TokenResponse;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BookerSteps {

    private final BookerAuthApi authApi = new BookerAuthApi();
    private final BookerBookingApi bookingApi = new BookerBookingApi();

    public String createToken(TokenRequest request) {
        Response res = authApi.createToken(request)
                .then().statusCode(200)
                .extract().response();

        TokenResponse token = res.as(TokenResponse.class);
        assertThat(token.getToken(), notNullValue());
        return token.getToken();
    }

    public int createBooking(BookingRequest request) {
        Response res = bookingApi.createBooking(request)
                .then().statusCode(200)
                .extract().response();

        CreateBookingResponse created = res.as(CreateBookingResponse.class);
        assertThat(created.getBookingid(), greaterThan(0));
        return created.getBookingid();
    }

    public BookingResponse getBooking(int bookingId) {
        Response res = bookingApi.getBooking(bookingId)
                .then().statusCode(200)
                .extract().response();

        return res.as(BookingResponse.class);
    }

    public void partialUpdateBooking(int bookingId, String token, PartialUpdateBookingRequest request) {
        bookingApi.partialUpdateBooking(bookingId, token, request)
                .then().statusCode(200);
    }

    public void deleteBooking(int bookingId, String token) {
        bookingApi.deleteBooking(bookingId, token)
                .then().statusCode(anyOf(is(200), is(201)));
    }

    public void partialUpdate(int bookingId, String token, PartialUpdateBookingRequest request) {
        bookingApi.partialUpdateBooking(bookingId, token, request)
                .then()
                .statusCode(200);
    }

    public void checkBookingDeleted(int bookingId) {
        bookingApi.getBooking(bookingId)
                .then()
                .statusCode(404);
    }
}
