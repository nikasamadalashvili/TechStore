package web.app.TechStore.TechStore.Chat.Coders;

import web.app.TechStore.TechStore.Chat.ChatMessage;

import javax.json.bind.JsonbBuilder;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {
    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {
    }

    @Override
    public ChatMessage decode(String textMessage) throws DecodeException {
        return JsonbBuilder.create().fromJson(textMessage, ChatMessage.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }
}