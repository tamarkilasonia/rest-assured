package ge.tbc.testautomation.data.model.swapi.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanetListItem(
        @JsonProperty("uid") String uid,
        @JsonProperty("name") String name,
        @JsonProperty("url") String url
) {}
