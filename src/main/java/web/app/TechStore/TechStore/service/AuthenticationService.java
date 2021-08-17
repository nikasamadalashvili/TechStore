package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.service.models.AuthenticationRequest;
import web.app.TechStore.TechStore.service.models.AuthenticationResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AuthenticationService {
    private EntityManager entityManager;

    public AuthenticationService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public AuthenticationResponse getUserId(AuthenticationRequest request){
        Query query = entityManager.createQuery("select u from Users u where" +
                "( u.username = :userName and u.password = :userPassword)");
        query.setParameter("userName", request.getUserName());
        query.setParameter("userPassword", request.getPassword());
        Users user;
        try{
            user = (Users) query.getSingleResult();
        }catch(Exception e){
            return new AuthenticationResponse(0, false);
        }
        return new AuthenticationResponse(user.getUserId(), true);
    }
}
