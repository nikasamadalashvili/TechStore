package web.app.TechStore.TechStore.service.models;

public class MobileDetailsResponse {
    private long productId;
    private String name;

    public MobileDetailsResponse(long productId, String name, String modelName) {
        this.productId = productId;
        this.name = name;
        this.modelName = modelName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    private String modelName;
}
