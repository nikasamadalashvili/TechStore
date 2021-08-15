package web.app.TechStore.TechStore.Chat.Behaviours;

import web.app.TechStore.TechStore.Chat.ChatMessage;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class ClientConnectionEntry implements ConnectionEntry{
    private final HashMap<String, HashSet<ConnectionEntry>> entries;
    private final Session session;

    public ClientConnectionEntry(HashMap<String, HashSet<ConnectionEntry>> entries, Session session) {
        this.entries = entries;
        this.session = session;
    }

    @Override
    public void send(ChatMessage message) {
        entries.entrySet().stream()
                .map(o -> o.getValue())
                .flatMap(Collection::stream)
                .filter(connectionEntry -> connectionEntry instanceof ProviderConnectionEntry && connectionEntry.getSession().isOpen())
                .forEach(connectionEntry -> connectionEntry.receive(message));
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
