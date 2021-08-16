package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.CreditCards;
import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.service.models.CreditCardRequest;
import web.app.TechStore.TechStore.service.models.CreditCardResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CreditCardService {
    private EntityManager entityManager;

    public CreditCardService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean addCreditCard(CreditCardRequest request) {
        CreditCards creditCard = new CreditCards(request.getCardNumber(),request.getCvv(),request.getExpiryDate(),request.getUserId());

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

    }

    public CreditCardResponse getCreditCardInfo(CreditCardRequest request) {

        CreditCards creditCard = (CreditCards) entityManager.createQuery("select c from CreditCards c where  c.userId = :id")
                .setParameter("id",request.getUserId()).getSingleResult();
        return CreditCardResponse.builder()
                .cardNumber(creditCard.getCardNumber())
                .cvv(creditCard.getCvv())
                .expiryDate(creditCard.getExpiryDate())
                .build();
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
