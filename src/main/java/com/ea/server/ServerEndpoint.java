package com.ea.server;

import com.ea.entity.MessageDecoder;
import com.ea.entity.MessageEncoder;
import com.ea.entity.Message;
import com.ea.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */


@javax.websocket.server.ServerEndpoint(value = "/chat", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ServerEndpoint {

    @Autowired
    Service service;

    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("%s joined the chat room.", session.getId()));
        peers.add(session);
    }

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {

        service.verifyMessage(message);

        //broadcast the message
        for (Session peer : peers) {
            if (!session.getId().equals(peer.getId())) { // do not resend the message to its sender
                peer.getBasicRemote().sendObject(message);
                System.out.println(format("message from user."+ message.getUserName(), "message from user."+ message.getText()));
            }
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println(format("%s left the chat room.", session.getId()));
        peers.remove(session);
        //notify peers about leaving the chat room
        for (Session peer : peers) {
            Message message = new Message();
            message.setUserName("Server");
            message.setText(format("%s left the chat room", (String) session.getUserProperties().get("user")));
            peer.getBasicRemote().sendObject(message);
        }
    }

}