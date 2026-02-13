package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EscuelaUsersApi extends BaseApi {

    public Response createUser(Object body) {
        return given()
                .spec(ESCUELA_SPEC)
                .body(body)
                .when()
                .post("/v1/users");
    }
}
