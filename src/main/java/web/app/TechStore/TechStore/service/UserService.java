package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.service.MobileService;

import javax.persistence.EntityManager;
import javax.xml.registry.infomodel.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private MobileService service;
    private EntityManager entityManager;

    public UserService(MobileService service, EntityManager entityManager) {
        this.service =  service;
        this.entityManager = entityManager;
    }

    public void addUser() {
        Users users = new Users();

        users.setFirstName("sopo");
        users.setUsername("sopo-");
        users.setPassword("sopoo");
        entityManager.getTransaction().begin();
        entityManager.persist(users);
        entityManager.getTransaction().commit();
    }

    public List<Long> getUser(String name) {
        return entityManager.createQuery("select s.userId from Users s where s.firstName = :name")
                     .setParameter("name",name).getResultList();
    }

}
