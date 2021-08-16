package web.app.TechStore.TechStore.service.models;

import web.app.TechStore.TechStore.DomainModels.ShoppingCartObjects;

import java.util.List;

public class ShoppingCartObjectsByUserResponse {
    List<ShoppingCartObjects> shoppingCartObjects;

    public ShoppingCartObjectsByUserResponse(List<ShoppingCartObjects> shoppingCartObjects) {
        this.shoppingCartObjects = shoppingCartObjects;
    }

    public List<ShoppingCartObjects> getShoppingCartObjects() {
        return shoppingCartObjects;
    }
}
