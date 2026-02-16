package ge.tbc.testautomation.data.model.restfulbooker.requests;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDates {
    private String checkin;
    private String checkout;
}
