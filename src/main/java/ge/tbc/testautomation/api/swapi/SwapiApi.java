package ge.tbc.testautomation.api.swapi;

import ge.tbc.testautomation.api.base.BaseApi;
import ge.tbc.testautomation.data.model.swapi.responses.PlanetDetailsResponse;
import ge.tbc.testautomation.data.model.swapi.responses.PlanetListResponse;

public class SwapiApi extends BaseApi {

    private static final String BASE = "https://www.swapi.tech";

    public PlanetListResponse getPlanetsList() {
        return base(BASE)
                .queryParam("format", "json")
                .when().get("/api/planets/")
                .then().statusCode(200)
                .extract().as(PlanetListResponse.class);
    }


    public PlanetDetailsResponse getPlanetDetails(String url) {
        return base(BASE)
                .when().get(url)
                .then().statusCode(200)
                .extract().as(PlanetDetailsResponse.class);
    }
}
