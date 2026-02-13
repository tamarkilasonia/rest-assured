package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookerBookingApi extends BaseApi {

    public Response createBooking(Object body) {
        return given()
                .spec(BOOKER_SPEC)
                .body(body)
                .when()
                .post("/booking");
    }

    public Response getBooking(int bookingId) {
        return given()
                .spec(BOOKER_SPEC)
                .when()
                .get("/booking/" + bookingId);
    }

    public Response partialUpdateBooking(int bookingId, String token, Object body) {
        return given()
                .spec(BOOKER_SPEC)
                .header("Cookie", "token=" + token)
                .header("Accept", "application/json")
                .body(body)
                .when()
                .patch("/booking/" + bookingId);
    }

    public Response deleteBooking(int bookingId, String token) {
        return given()
                .spec(BOOKER_SPEC)
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId);
    }
}
