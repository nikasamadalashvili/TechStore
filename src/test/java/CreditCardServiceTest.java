import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.app.TechStore.TechStore.DomainModels.CreditCards;
import web.app.TechStore.TechStore.Services.CreditCardService;
import web.app.TechStore.TechStore.Services.models.CreditCardRequest;
import web.app.TechStore.TechStore.Services.models.CreditCardResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardServiceTest {
    private CreditCardService cardService;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.cardService = new CreditCardService(entityManager);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCreditCard() {
        CreditCardRequest request = CreditCardRequest.builder().userId(4L)
                                    .cardNumber("123456589").cvv("201").name("spo")
                                    .expiryDate("2023").build();
        boolean check = cardService.addCreditCard(request);
        if(check) {
            CreditCards cards = (CreditCards) entityManager.createQuery("select c from CreditCards c where c.userId = 2L")
                    .getSingleResult();
            assertEquals("201",cards.getCvv());
            assertEquals("2023",cards.getExpiryDate());
            assertEquals("123456589",cards.getCardNumber());
        }
    }

    @Test
    void getCreditCardInfo() {
        CreditCardRequest request = CreditCardRequest.builder().userId(2L)
                .build();
        CreditCardResponse response = cardService.getCreditCardInfo(request);
        assertEquals("201",response.getCvv());
        assertEquals("2023",response.getExpiryDate());
    }

    @Test
    void changeCreditCardInfo() {
        CreditCardRequest request = CreditCardRequest.builder().userId(2L)
                .cardNumber("").cvv("301").expiryDate("").build();
        CreditCardResponse response = cardService.changeCreditCardInfo(request);
        assertEquals("501",response.getCvv());
        assertEquals("2023",response.getExpiryDate());
    }

    @Test
    void deleteCreditCard() {
        CreditCardRequest request = CreditCardRequest.builder().userId(2L)
                .build();
        cardService.deleteCreditCard(request);
    }
}