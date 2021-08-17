package web.app.TechStore.TechStore.Services.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardResponse {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private boolean present;
    //private String name;
}
