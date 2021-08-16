package web.app.TechStore.TechStore.service.models;

public class AddShoppingCartObjectResponse {
    boolean addedSuccesfully;
    long shoppingCartObjectId;

    public AddShoppingCartObjectResponse(boolean addedSuccesfully, long shoppingCartObjectId) {
        this.addedSuccesfully = addedSuccesfully;
        this.shoppingCartObjectId = shoppingCartObjectId;
    }

    public boolean isAddedSuccesfully() {
        return addedSuccesfully;
    }

    public long getShoppingCartObjectId() {
        return shoppingCartObjectId;
    }
}
