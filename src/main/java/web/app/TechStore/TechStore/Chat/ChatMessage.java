package web.app.TechStore.TechStore.Chat;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbVisibility;
import java.util.Date;

public class ChatMessage {
    private String message;
    private String from;
    private String to;
    private Date sentDate;

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}