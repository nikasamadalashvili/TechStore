package web.app.TechStore.TechStore.Services.models;

public class EditProductResponse {
    boolean updatedSuccesfully;

    public EditProductResponse(boolean updatedSuccesfully) {
        this.updatedSuccesfully = updatedSuccesfully;
    }

    public boolean isUpdatedSuccesfully() {
        return updatedSuccesfully;
    }
}
