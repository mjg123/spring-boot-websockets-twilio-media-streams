package lol.gilliard.mediastreams.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

public class WebSocketHandler extends AbstractWebSocketHandler {

    static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        logger.info("Message Received: {}", message.getPayload());
        session.sendMessage(new TextMessage("Message Received: " + message.getPayload()));
    }

}
