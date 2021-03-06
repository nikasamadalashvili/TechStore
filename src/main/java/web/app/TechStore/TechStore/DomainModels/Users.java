package web.app.TechStore.TechStore.DomainModels;

import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Entity
public class Users {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String image;
    private Roles rolesByRoleId;
    private String salt;

    public Users() {
    }

    public Users(long userId, String firstName, String lastName, String email, String username, String password, String image, Roles rolesByRoleId,String salt) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.rolesByRoleId = rolesByRoleId;
        this.salt = salt;
    }

    @Id
    @Column(name = "userID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "salt", nullable = false, length = 64)
    public String getSalt() { return salt;}

    public void setSalt(String salt) { this.salt = salt;}

    @Basic
    @Column(name = "first_name", nullable = true, length = 64)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 64)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 64)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(image, users.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, username, password, image);
    }

    @ManyToOne
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
