package com.ea.dao;

import com.ea.entity.Message;
import com.ea.entity.User;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ravikumarpothuganti on 2017-08-20.
 */
public class MessagesDao {

    private static Map<Integer, Message> messages;


    public Collection<Message> getTopTenMessages(){
        return this.messages.values();
    }

    public void insertMessageToDb(Message message) {
        this.messages.put(message.getId(), message);
    }

}
