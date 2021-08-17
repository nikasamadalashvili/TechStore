package web.app.TechStore.TechStore.Services.models;

public class EditRoleResponse {
    private boolean editedSuccesfully;

    public EditRoleResponse(boolean editedSuccesfully) {
        this.editedSuccesfully = editedSuccesfully;
    }

    public boolean isEditedSuccesfully() {
        return editedSuccesfully;
    }
}
