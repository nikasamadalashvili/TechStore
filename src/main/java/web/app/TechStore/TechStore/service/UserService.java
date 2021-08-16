package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.service.models.UserDetails;
import web.app.TechStore.TechStore.service.models.UserDetailsRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserService {

    private MobileService service;
    private EntityManager entityManager;

    public UserService(MobileService service, EntityManager entityManager) {
        this.service =  service;
        this.entityManager = entityManager;
    }

    public UserDetails getUserDetails(UserDetailsRequest request) {
        Users user = entityManager.find(Users.class,request.getId());
        return UserDetails.UserToDetails(user);
    }

    public boolean addNewUser(UserDetails details) {
        Users users = UserDetails.DetailsToUser(details);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(users);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return true;
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public boolean changeProfile(UserDetailsRequest request, UserDetails details) {
        Users user = entityManager.find(Users.class,request.getId());


        Query query = entityManager.createQuery("update Users s set s.firstName = :firstName, " +
                "s.lastName = :lastName, s.email = :email, s.image = :image, s.username = :username where s.userId = :id");
        query.setParameter("firstName",!details.getFirstName().equals("")? details.getFirstName():user.getFirstName());
        query.setParameter("lastName", !details.getLastName().equals("")? details.getLastName() : user.getLastName());
        query.setParameter("email",!details.getEmail().equals("")? details.getEmail(): user.getEmail());
        query.setParameter("image",!details.getImage().equals("")? details.getImage() : user.getImage());
        query.setParameter("id",request.getId());
        query.setParameter("username",!details.getUsername().equals("")? details.getUsername() : user.getUsername());


        try {
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
            return true;
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

}
