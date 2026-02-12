package ge.tbc.testautomation.data.model.swapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanetDetailsResult(
        @JsonProperty("properties") PlanetProperties properties
) {}
