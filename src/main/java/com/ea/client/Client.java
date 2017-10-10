package com.ea.client;

import static com.ea.utils.JsonUtil.formatMessage;
/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */

import java.net.URI;
import java.util.Scanner;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

public class Client {

    public static final String SERVER = "ws://localhost:8025/ws/chat";

    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();
        String message;

        // connect to server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to EA Chat!");
        System.out.println("Enter your name?");
        String user = scanner.nextLine();
        Session session = client.connectToServer(ClientEndpoint.class, new URI(SERVER));
        System.out.println("You are logged in as: " + user);

        // repeatedly read a message and send it to the server (until quit)
        do {
            message = scanner.nextLine();
            session.getBasicRemote().sendText(formatMessage(message, user));
        } while (!message.equalsIgnoreCase("quit"));
    }

}

