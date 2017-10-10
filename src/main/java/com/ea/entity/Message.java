package com.ea.entity;

import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
public class Message {
    private int id;
    //private Set<String> userIdentifier;
    //private ConcurrentLinkedDeque<String> chatData;
    private String text;
    private String userName;
    private int messageScore;
    private Topic topic;

    public Message(int id, String userName, String text, int messageScore,Topic topic) {
        this.id = id;
        //this.userIdentifier= userIdentifier;
        this.userName = userName;
        //this.chatData = chatData;
        this.text = text;
        this.messageScore = messageScore;
        this.topic=topic;
    }

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMessageScore() {
        return messageScore;
    }

    public void setMessageScore(int messageScore) {
        this.messageScore = messageScore;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userFirstName='" + userName + '\'' +
                ", messageScore=" + messageScore +
                ", topic=" + topic +
                '}';
    }
}
