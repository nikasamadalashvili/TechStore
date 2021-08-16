package web.app.TechStore.TechStore.service.models;

public class EditShoppingCartObjectResponse {
    boolean editedSuccesfully;

    public EditShoppingCartObjectResponse(boolean editedSuccesfully) {
        this.editedSuccesfully = editedSuccesfully;
    }

    public boolean isEditedSuccesfully() {
        return editedSuccesfully;
    }
}
