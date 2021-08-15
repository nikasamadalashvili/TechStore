package web.app.TechStore.TechStore.Chat.Behaviours;

import web.app.TechStore.TechStore.Chat.ChatMessage;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;

public interface ConnectionEntry {
    void send(ChatMessage message);
    void receive(ChatMessage message);
    Session getSession();
}
