package web.app.TechStore.TechStore.service.models;

public class BuyCartProductsRequest {
    private long userId;

    public BuyCartProductsRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
