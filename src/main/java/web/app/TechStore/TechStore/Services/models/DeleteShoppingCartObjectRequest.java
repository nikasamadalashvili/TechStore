package web.app.TechStore.TechStore.Services.models;

public class DeleteShoppingCartObjectRequest {
    private long shoppingCartId;

    public DeleteShoppingCartObjectRequest(long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public long getShoppingCartId() {
        return shoppingCartId;
    }
}
