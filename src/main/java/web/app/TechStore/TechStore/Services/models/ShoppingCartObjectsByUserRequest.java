package web.app.TechStore.TechStore.Services.models;

public class ShoppingCartObjectsByUserRequest {
    long userId;

    public ShoppingCartObjectsByUserRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
