package ge.tbc.testautomation.data.model.swapi.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record PlanetListResponse(
        @JsonProperty("results") List<PlanetListItem> results
) {}
