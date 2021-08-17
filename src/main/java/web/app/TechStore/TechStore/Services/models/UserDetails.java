package web.app.TechStore.TechStore.Services.models;

import lombok.Builder;
import lombok.Data;
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
                .build();
    }

    public UserDetails(String firstName, String lastName, String email, String username, String password, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
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
