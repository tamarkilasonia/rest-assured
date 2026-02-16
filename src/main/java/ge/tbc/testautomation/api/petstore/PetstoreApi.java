package ge.tbc.testautomation.api.petstore;

import ge.tbc.testautomation.api.base.BaseApi;
import ge.tbc.testautomation.data.model.petstore.requests.StoreOrderRequest;
import ge.tbc.testautomation.data.model.petstore.responses.StoreOrderResponse;

public class PetstoreApi extends BaseApi {

    private static final String BASE = "https://petstore3.swagger.io";

    public StoreOrderResponse createOrder(StoreOrderRequest request) {
        return base(BASE)
                .body(request)
                .when().post("/api/v3/store/order")
                .then().statusCode(200)
                .extract().as(StoreOrderResponse.class);
    }
}
