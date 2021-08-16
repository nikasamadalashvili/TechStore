package web.app.TechStore.TechStore.service.models;

public class AddNewRoleResponse {
    private boolean addedSuccesfully;

    public AddNewRoleResponse(boolean addedSuccesfully) {
        this.addedSuccesfully = addedSuccesfully;
    }

    public boolean isAddedSuccesfully() {
        return addedSuccesfully;
    }
}
