package web.app.TechStore.TechStore.Services;

import web.app.TechStore.TechStore.DomainModels.Roles;
import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.Services.models.*;
import web.app.TechStore.TechStore.Utils.SecurityUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@RequestScoped
public class AuthenticationService {

    private EntityManager entityManager;
    private UserService userService;

    @Inject
    public AuthenticationService(EntityManager entityManager, UserService userService) {
        this.entityManager = entityManager;
        this.userService = userService;
    }

    public AuthenticationService() {}

    public AuthenticationResponse getUserId(AuthenticationRequest request){
        Query query = entityManager.createQuery("select u from Users u where" +
                "( u.username = :userName )");
        query.setParameter("userName", request.getUserName());
        Users user;
        try{
            user = (Users) query.getSingleResult();
            String hashedPass = SecurityUtils.getHashedValue(request.getPassword(), user.getSalt().getBytes());
            if (!hashedPass.equals(user.getPassword()))
                throw new Exception();
        }catch(Exception e){
            return new AuthenticationResponse(0, false, "");
        }
        return new AuthenticationResponse(user.getUserId(), true, user.getUsername());
    }

    public SignUpUserResponse signUpUser(SignUpUserRequest request) {
        String salt = SecurityUtils.generateRandomString();
        Roles roles = (Roles) entityManager.createQuery("select r from Roles r where r.roleName = 'customer'").getSingleResult();
        AddNewUserResponse addNewUserResponse = userService.addNewUser(new UserDetails(request.FirstName, request.LastName,
                request.Email, request.UserName, SecurityUtils.getHashedValue(request.Password, salt.getBytes()), salt, "testImage.jpg",roles));
        SignUpUserResponse response = new SignUpUserResponse();
        response.HasSucceeded = addNewUserResponse.IsSuccess;
        response.User = addNewUserResponse.User;
        return response;
    }
}
