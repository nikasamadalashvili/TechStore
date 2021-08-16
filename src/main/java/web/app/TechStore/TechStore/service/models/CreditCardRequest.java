package web.app.TechStore.TechStore.service.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardRequest {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String name;
    private Long userId;
}
