package web.app.TechStore.TechStore.Services.models;

public class AuthenticationResponse {
    private long userId;
    boolean isIdAndPassRight;
    private String userName;

    public AuthenticationResponse(long userId, boolean isIdAndPassRight, String userName) {
        this.userId = userId;
        this.isIdAndPassRight = isIdAndPassRight;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public boolean isIdAndPassRight() {
        return isIdAndPassRight;
    }

    public String getUserName() {
        return userName;
    }
}
