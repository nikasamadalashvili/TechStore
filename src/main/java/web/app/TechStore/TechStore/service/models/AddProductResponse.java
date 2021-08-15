package web.app.TechStore.TechStore.service.models;

public class AddProductResponse {

    boolean addedSuccesfully;
    long productId;

    public AddProductResponse(boolean addedSuccesfully, long productId){
        this.productId = productId;
        this.addedSuccesfully = addedSuccesfully;
    }

    public boolean isAddedSuccesfully() {
        return addedSuccesfully;
    }

    public long getProductId() {
        return productId;
    }
}
