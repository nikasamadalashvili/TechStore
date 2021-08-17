package web.app.TechStore.TechStore.Services.models;



public class AddShoppingCartObjectRequest {
    long productId;
    long userId;
    Integer productQuantity;

    public AddShoppingCartObjectRequest(long productId, long userId, Integer productQuantity) {
        this.productId = productId;
        this.userId = userId;
        this.productQuantity = productQuantity;
    }

    public long getProductId() {
        return productId;
    }

    public long getUserId() {
        return userId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }
}
