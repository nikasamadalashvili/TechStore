package web.app.TechStore.TechStore.Services.models;

import web.app.TechStore.TechStore.DomainModels.Users;

public class AddNewUserResponse {
    public Users User;
    public boolean IsSuccess;

    public AddNewUserResponse(Users user, boolean isSuccess) {
        User = user;
        IsSuccess = isSuccess;
    }
}
