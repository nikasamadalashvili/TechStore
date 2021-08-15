package web.app.TechStore.TechStore.Chat.Coders;

import web.app.TechStore.TechStore.Chat.ChatMessage;

import javax.json.Json;
import javax.json.bind.JsonbBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(ChatMessage chatMessage) throws EncodeException {
        return JsonbBuilder.create().toJson(chatMessage);
    }
}