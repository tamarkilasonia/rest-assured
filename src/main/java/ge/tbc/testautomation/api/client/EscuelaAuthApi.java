package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EscuelaAuthApi extends BaseApi {

    public Response login(Object body) {
        return given()
                .spec(ESCUELA_SPEC)
                .body(body)
                .when()
                .post("/v1/auth/login");
    }

    public Response profile(String accessToken) {
        return given()
                .spec(ESCUELA_SPEC)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/v1/auth/profile");
    }
}
 