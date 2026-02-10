package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookerAuthApi extends BaseApi {

    public Response createToken(Object body) {
        return given()
                .spec(BOOKER_SPEC)
                .body(body)
                .when()
                .post("/auth");
    }
}
