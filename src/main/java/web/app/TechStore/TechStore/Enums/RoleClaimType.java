package web.app.TechStore.TechStore.Enums;

public enum RoleClaimType {
    CREDIT_CARD(1),
    SHOPPING_CARD(2),
    PRODUCTS(4),
    PROFILE(8);

    private final int value;

    private RoleClaimType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
