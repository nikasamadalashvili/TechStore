package web.app.TechStore.TechStore.service.models;

public class AddProductResponse {

    boolean addedSuccesfully;

    public AddProductResponse(boolean addedSuccesfully){
        this.addedSuccesfully = addedSuccesfully;
    }

    public boolean isAddedSuccesfully() {
        return addedSuccesfully;
    }
}
