package web.app.TechStore.TechStore.Utils;

import java.util.Date;

public class TechStoreAuthenticationCookieModel {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    private String userName;
    private Date expirationDate;
}
