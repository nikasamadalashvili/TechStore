package webapp.techstore;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;


@RequestScoped
public class repo {

    @PersistenceContext
    EntityManager entityManager;

    public void update() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(new model(1,"gela"));
        transaction.commit();
    }
}
