package ge.tbc.testautomation.data.model.swapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanetDetailsResponse(
        @JsonProperty("result") PlanetDetailsResult result
) {}
