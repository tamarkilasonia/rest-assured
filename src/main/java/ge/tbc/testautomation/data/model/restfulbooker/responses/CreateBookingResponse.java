package ge.tbc.testautomation.data.model.restfulbooker.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import ge.tbc.testautomation.data.model.restfulbooker.requests.UpdateBookingRequest;
import lombok.Data;

@Data
public class CreateBookingResponse {
    @JsonProperty("bookingid")
    private int bookingId;

    @JsonProperty("booking")
    private UpdateBookingRequest booking;
}
