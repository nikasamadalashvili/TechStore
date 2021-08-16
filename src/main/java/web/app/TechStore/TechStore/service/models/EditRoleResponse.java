package web.app.TechStore.TechStore.service.models;

public class EditRoleResponse {
    private boolean editedSuccesfully;

    public EditRoleResponse(boolean editedSuccesfully) {
        this.editedSuccesfully = editedSuccesfully;
    }

    public boolean isEditedSuccesfully() {
        return editedSuccesfully;
    }
}
