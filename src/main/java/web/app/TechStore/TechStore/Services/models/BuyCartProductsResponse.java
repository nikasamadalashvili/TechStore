package web.app.TechStore.TechStore.Services.models;

public class BuyCartProductsResponse {
    private Double totalCost;

    public BuyCartProductsResponse(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
