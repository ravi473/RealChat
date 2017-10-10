package com.ea.dao;

import com.ea.entity.Message;
import com.ea.entity.Topic;
import com.ea.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ravikumarpothuganti on 2017-08-20.
 */
public class MessagesDao {

    //private static Map<Integer, Message> messages;
    private ConcurrentHashMap<Integer , Message> chatTopicUserContent;


    public Collection<Message> getTopTenMessages(){
        return this.chatTopicUserContent.values();
    }

    public void insertMessageToDb(Message message) {
        this.chatTopicUserContent.putIfAbsent(message.getId(),message);
    }

    public Message getTopic(Topic topic){

        return this.chatTopicUserContent.get(topic);
    }

}
