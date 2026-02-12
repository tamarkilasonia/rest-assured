package ge.tbc.testautomation.data.model.restfulbooker.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ge.tbc.testautomation.data.model.restfulbooker.requests.BookingDates;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBookingRequest {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer saleprice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String passportNo;
}
