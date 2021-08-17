package web.app.TechStore.TechStore.Services.models;

public class AuthenticationResponse {
    private long userId;
    boolean isIdAndPassRight;

    public AuthenticationResponse(long userId, boolean isIdAndPassRight) {
        this.userId = userId;
        this.isIdAndPassRight = isIdAndPassRight;
    }

    public long getUserId() {
        return userId;
    }

    public boolean isIdAndPassRight() {
        return isIdAndPassRight;
    }
}
