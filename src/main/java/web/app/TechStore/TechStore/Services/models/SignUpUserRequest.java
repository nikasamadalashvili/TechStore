package web.app.TechStore.TechStore.Services.models;

public class SignUpUserRequest {
    public String UserName;
    public String Password;
    public String Email;
    public String FirstName;
    public String LastName;

    public SignUpUserRequest(String userName, String password, String email, String firstName, String lastName) {
        UserName = userName;
        Password = password;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
    }
}
