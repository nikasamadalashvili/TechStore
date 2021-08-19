package web.app.TechStore.TechStore.Services.models;

import web.app.TechStore.TechStore.DomainModels.ShoppingCartObjects;

import java.util.List;

public class ShoppingCartObjectsByUserResponse {
    List<ShoppingCartObjects> shoppingCartObjects;
    Double totalCost;

    public ShoppingCartObjectsByUserResponse(List<ShoppingCartObjects> shoppingCartObjects, Double totalCost) {
        this.shoppingCartObjects = shoppingCartObjects;
        this.totalCost = totalCost;
    }

    public List<ShoppingCartObjects> getShoppingCartObjects() {
        return shoppingCartObjects;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
