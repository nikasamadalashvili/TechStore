package web.app.TechStore.TechStore.Services.models;

public class EditShoppingCartObjectRequest {
    private long shoppingCartId;
    Integer productQuantity;

    public EditShoppingCartObjectRequest(long shoppingCartId, Integer productQuantity) {
        this.shoppingCartId = shoppingCartId;
        this.productQuantity = productQuantity;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }
}
