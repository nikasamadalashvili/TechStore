package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;

@Entity
public class CreditCards {
    private long creditCardId;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private Users userByUserId;

    public CreditCards(long creditCardId, String cardNumber, String expiryDate, String cvv, Users userByUserId) {
        this.creditCardId = creditCardId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.userByUserId = userByUserId;
    }

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

    @Basic
    @Column(name = "cardNumber", nullable = false, length = 64)
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
    @Column(name = "cvv", nullable = false, length = 64)
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }


    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    public Users getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(Users userByUserId) {
        this.userByUserId = userByUserId;
    }
}
