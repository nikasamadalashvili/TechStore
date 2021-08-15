package web.app.TechStore.TechStore.Chat;

import web.app.TechStore.TechStore.Chat.Behaviours.ClientConnectionEntry;
import web.app.TechStore.TechStore.Chat.Behaviours.ConnectionEntry;
import web.app.TechStore.TechStore.Chat.Behaviours.ProviderConnectionEntry;
import web.app.TechStore.TechStore.Chat.Coders.ChatMessageDecoder;
import web.app.TechStore.TechStore.Chat.Coders.ChatMessageEncoder;
import web.app.TechStore.TechStore.DomainModels.Products;
import web.app.TechStore.TechStore.DomainModels.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/CustomChat", encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class ChatEndpoint {
    private static HashMap<String, HashSet<ConnectionEntry>> connections = new HashMap<>();
    private EntityManager entityManager;

    public ChatEndpoint() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @OnOpen
    public void open(Session session) throws Exception {
        String username = session.getRequestParameterMap().get("username").stream().findFirst().get();
        ConnectionEntry newConnection = null;
        if (!connections.containsKey(username)) {
            connections.put(username, new HashSet<>());
        }
        Query query = entityManager.createQuery("select u from Users u where u.username = :username");
        query.setParameter("username", username);
        Optional<Users> userResult = ((List<Users>) query.getResultList()).stream().findFirst();
        if (!userResult.isPresent())
            throw new Exception();
        Users user = userResult.get();
        newConnection = user.getRolesByRoleId().getRoleName().equals("customer") ? new ClientConnectionEntry(connections, session) : new ProviderConnectionEntry(connections, session);

        connections.get(username).add(newConnection);
        session.getUserProperties().put("self", newConnection);
        session.getUserProperties().put("username", username);
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage chatMessage) {
        ConnectionEntry entry = (ConnectionEntry) session.getUserProperties().get("self");
        entry.send(chatMessage);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        String username = (String) session.getUserProperties().get("username");
        HashSet<ConnectionEntry> sessions = connections.get(username);
        ConnectionEntry target = sessions.stream().filter(o -> o.getSession().equals(session)).findFirst().get();
        sessions.remove(target);
        if (sessions.size() == 0)
            connections.remove(username);
    }
}