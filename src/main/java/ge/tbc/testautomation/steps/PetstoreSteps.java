package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.api.petstore.PetstoreApi;
import ge.tbc.testautomation.data.model.petstore.requests.StoreOrderRequest;
import ge.tbc.testautomation.data.model.petstore.responses.StoreOrderResponse;

public class PetstoreSteps {

    private final PetstoreApi api = new PetstoreApi();

    public StoreOrderResponse createOrder() {

        StoreOrderRequest request = new StoreOrderRequest()
                .id(1001L)
                .petId(2002L)
                .quantity(3)
                .shipDate("2026-02-12T10:00:00.000Z")
                .status("placed")
                .complete(false);

        return api.createOrder(request);
    }
}
