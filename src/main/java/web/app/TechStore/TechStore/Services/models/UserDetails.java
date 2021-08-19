package web.app.TechStore.TechStore.Services.models;

import lombok.Builder;
import lombok.Data;
import web.app.TechStore.TechStore.DomainModels.Roles;
import web.app.TechStore.TechStore.DomainModels.Users;

@Builder
@Data
public class UserDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String image;
    private String salt;
    private Roles roles;

    public static UserDetails UserToDetails(Users user) {
        return UserDetails.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .image(user.getImage()).build();
    }

    public static Users DetailsToUser(UserDetails response) {
        return Users.builder().firstName(response.getFirstName())
                .lastName(response.getLastName())
                .email(response.getEmail())
                .username(response.getUsername())
                .image(response.getImage())
                .password(response.getPassword())
                .salt(response.getSalt())
                .rolesByRoleId(response.getRoles())
                .build();
    }

    public UserDetails(String firstName, String lastName, String email, String username, String password, String salt, String image, Roles roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.salt = salt;
        this.roles = roles;
    }

    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, String email, String username, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.image = image;
    }
}
