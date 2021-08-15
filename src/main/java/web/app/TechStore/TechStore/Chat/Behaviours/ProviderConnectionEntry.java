package web.app.TechStore.TechStore.Chat.Behaviours;

import web.app.TechStore.TechStore.Chat.ChatMessage;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ProviderConnectionEntry implements ConnectionEntry{
    private HashMap<String, HashSet<ConnectionEntry>> entries;
    private Session session;

    public ProviderConnectionEntry(HashMap<String, HashSet<ConnectionEntry>> entries, Session session) {
        this.entries = entries;
        this.session = session;
    }

    @Override
    public void send(ChatMessage message) {
        HashSet<ConnectionEntry> client = entries.get(message.getTo());
        for (ConnectionEntry connectionEntry : client) {
            connectionEntry.receive(message);
        }
        receive(message);
    }

    @Override
    public void receive(ChatMessage message) {
        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Session getSession() {
        return session;
    }
}
