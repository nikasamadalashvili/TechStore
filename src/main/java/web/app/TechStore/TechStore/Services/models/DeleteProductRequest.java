package web.app.TechStore.TechStore.Services.models;

public class DeleteProductRequest {
    private long productId;

    public DeleteProductRequest(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
