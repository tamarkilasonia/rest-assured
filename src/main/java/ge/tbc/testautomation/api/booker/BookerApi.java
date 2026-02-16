package ge.tbc.testautomation.api.booker;

import ge.tbc.testautomation.api.base.BaseApi;
import ge.tbc.testautomation.data.model.restfulbooker.requests.AuthRequest;
import ge.tbc.testautomation.data.model.restfulbooker.requests.UpdateBookingRequest;
import ge.tbc.testautomation.data.model.restfulbooker.responses.AuthResponse;
import ge.tbc.testautomation.data.model.restfulbooker.responses.CreateBookingResponse;

public class BookerApi extends BaseApi {

    private static final String BASE = "https://restful-booker.herokuapp.com/";

    public AuthResponse createToken(AuthRequest request) {
        return base(BASE)
                .body(request)
                .when().post("/auth")
                .then().statusCode(200)
                .extract().as(AuthResponse.class);
    }

    public CreateBookingResponse createBooking(UpdateBookingRequest request) {
        return base(BASE)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(request)
                .when().post("booking")
                .then()
                .statusCode(200)
                .extract().as(CreateBookingResponse.class);
    }

    public UpdateBookingRequest updateBooking(int bookingId, String token, UpdateBookingRequest request) {
        return base(BASE)
                .header("Cookie", "token=" + token)
                .body(request)
                .when().put("booking" + bookingId)
                .then().statusCode(200)
                .extract().as(UpdateBookingRequest.class);
    }
}
