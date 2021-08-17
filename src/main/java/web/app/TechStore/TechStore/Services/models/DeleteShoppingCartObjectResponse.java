package web.app.TechStore.TechStore.Services.models;

public class DeleteShoppingCartObjectResponse {
    boolean deletedSuccesfully;

    public DeleteShoppingCartObjectResponse(boolean deletedSuccesfully) {
        this.deletedSuccesfully = deletedSuccesfully;
    }

    public boolean isDeletedSuccesfully() {
        return deletedSuccesfully;
    }
}
