package web.app.TechStore.TechStore.BeanManagers;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class MyEntityManagerProducer{
    @Produces
    public EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("tech-store").createEntityManager();
    }
}