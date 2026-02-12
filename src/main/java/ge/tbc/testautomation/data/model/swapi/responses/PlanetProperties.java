package ge.tbc.testautomation.data.model.swapi.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ge.tbc.testautomation.utils.TimeParsers;

import java.time.LocalDateTime;

public record PlanetProperties(
        @JsonProperty("name") String name,
        @JsonProperty("rotation_period") String rotationPeriod,
        @JsonProperty("climate") String climate,
        @JsonProperty("terrain") String terrain,
        @JsonProperty("population") String population,


        @JsonProperty("edited")
        @JsonDeserialize(using = TimeParsers.class)
        LocalDateTime timestamp
) {}
