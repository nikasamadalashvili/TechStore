package web.app.TechStore.TechStore.Services;

import web.app.TechStore.TechStore.DomainModels.CreditCards;
import web.app.TechStore.TechStore.Services.models.CreditCardRequest;
import web.app.TechStore.TechStore.Services.models.CreditCardResponse;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@RequestScoped
public class CreditCardService {
    private EntityManager entityManager;

    public CreditCardService() {}

    @Inject
    public CreditCardService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean addCreditCard(CreditCardRequest request) {
        CreditCards creditCard = new CreditCards(request.getCardNumber(),request.getCvv(),request.getExpiryDate(),request.getUserId());
        if(!getCreditCardInfo(request).isPresent()) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(creditCard);
                entityManager.flush();
                entityManager.getTransaction().commit();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
        } {
            return false;
        }
    }

    public CreditCardResponse getCreditCardInfo(CreditCardRequest request) {
        CreditCards creditCard = new CreditCards();
        try {
            creditCard = (CreditCards) entityManager.createQuery("select c from CreditCards c where  c.userId = :id")
                    .setParameter("id", request.getUserId()).getSingleResult();
            return CreditCardResponse.builder()
                    .cardNumber(creditCard.getCardNumber())
                    .cvv(creditCard.getCvv())
                    .expiryDate(creditCard.getExpiryDate())
                    .present(true)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return CreditCardResponse.builder().present(false).build();
        }
    }

    public CreditCardResponse changeCreditCardInfo(CreditCardRequest request) {
           CreditCardResponse creditCardResponse = getCreditCardInfo(request);

        Query query = entityManager.createQuery("update CreditCards c set c.cardNumber = :cardNumber, c.cvv = :cvv, c.expiryDate = :exp " +
                "where c.userId = :id");
        query.setParameter("id",request.getUserId());
        query.setParameter("cardNumber",!request.getCardNumber().equals("") ? request.getCardNumber() : creditCardResponse.getCardNumber());
        query.setParameter("cvv", !request.getCvv().equals("") ? request.getCvv() : creditCardResponse.getCvv());
        query.setParameter("exp", !request.getExpiryDate().equals("") ? request.getExpiryDate() : creditCardResponse.getExpiryDate());

        try {
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch(Exception e ) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return getCreditCardInfo(request);
    }

    public boolean deleteCreditCard(CreditCardRequest request) {
        Query query = entityManager.createQuery("delete from CreditCards c where c.userId = :id");
        query.setParameter("id",request.getUserId());

        try {
            entityManager.getTransaction().begin();
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
