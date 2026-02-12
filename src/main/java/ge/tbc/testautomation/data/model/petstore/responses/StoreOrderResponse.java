package ge.tbc.testautomation.data.model.petstore.responses;

import lombok.Data;

@Data
public class StoreOrderResponse {
    private Long id;
    private Long petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
}
