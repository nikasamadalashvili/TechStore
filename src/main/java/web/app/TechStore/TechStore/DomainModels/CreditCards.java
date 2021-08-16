package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CreditCards {
    private long creditCardId;
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private Long userId;

    public CreditCards() {

    }

    @Id
    @Column(name = "creditCardId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public CreditCards(String cardNumber, String cvv, String expiryDate, Long userId) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }

    @Basic
    @Column(name = "cardNumber", nullable = false, length = 64)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "cvv", nullable = false, length = 64)
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Basic
    @Column(name = "expiryDate", nullable = false, length = 64)
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Basic
    @Column(name = "userID", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCards that = (CreditCards) o;
        return creditCardId == that.creditCardId && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(cvv, that.cvv) && Objects.equals(expiryDate, that.expiryDate) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditCardId, cardNumber, cvv, expiryDate, userId);
    }
}
