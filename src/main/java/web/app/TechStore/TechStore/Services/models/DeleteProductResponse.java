package web.app.TechStore.TechStore.Services.models;

public class DeleteProductResponse {

    private boolean deletedSuccesfully;

    public DeleteProductResponse(boolean deletedSuccesfully) {
        this.deletedSuccesfully = deletedSuccesfully;
    }

    public boolean isDeletedSuccesfully() {
        return deletedSuccesfully;
    }
}
