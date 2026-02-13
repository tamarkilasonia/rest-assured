package ge.tbc.testautomation.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ToolsQaBookStoreApi extends BaseApi {

    public Response getBooks() {
        return given()
                .spec(TOOLSQA_SPEC)
                .when()
                .get("/BookStore/v1/Books");
    }
}
