package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.api.petstore.PetstoreApi;
import ge.tbc.testautomation.config.BaseTest;
import ge.tbc.testautomation.data.model.petstore.requests.StoreOrderRequest;
import ge.tbc.testautomation.data.model.petstore.responses.StoreOrderResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetstoreTests extends BaseTest {

    @Test
    public void petstore_createOrder_shouldValidateResponse() {
        PetstoreApi api = new PetstoreApi();

        StoreOrderRequest req = new StoreOrderRequest()
                .id(1001L)
                .petId(2002L)
                .quantity(2)
                .shipDate("2026-02-12T10:00:00.000Z")
                .status("placed")
                .complete(false);

        StoreOrderResponse resp = api.createOrder(req);
        Assert.assertNotNull(resp.getId());
        Assert.assertEquals(resp.getQuantity(), req.quantity());
        Assert.assertEquals(resp.getStatus(), req.status());
        Assert.assertEquals(resp.getComplete(), req.complete());



    }
}