package com.ea.client;

/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */
import com.ea.entity.Message;
import com.ea.entity.MessageDecoder;
import com.ea.entity.MessageEncoder;

import static java.lang.String.format;


import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.text.SimpleDateFormat;

@javax.websocket.ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndpoint {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("Connection established. session id: %s", session.getId()));
    }

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(format("[%s:%s] %s", message.getId(), message.getUserName(), message.getText(), message.getMessageScore(),message.getTopic()));
    }

}

