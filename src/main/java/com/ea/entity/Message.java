package com.ea.entity;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
public class Message {
    private int id;
    private String text;
    private int topicId;
    private String userName;
    private int messageScore;

    public Message(int id, String userName, int topicId, String text,int messageScore) {
        this.id = id;
        this.userName = userName;
        this.topicId = topicId;
        this.text = text;
        this.messageScore = messageScore;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
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

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", topicId=" + topicId +
                ", userName='" + userName + '\'' +
                ", messageScore=" + messageScore +
                '}';
    }
}
