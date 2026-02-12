package ge.tbc.testautomation.api.base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseApi {

    protected RequestSpecification base(String baseUri) {
        return given()
                .baseUri(baseUri)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }
}