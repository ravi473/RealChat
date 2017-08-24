package com.ea.entity;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
public class Topic {
    private int id;
    private String name;

    public Topic(int id, String name){
        this.id=id;
        this.name=name;
    }
    public Topic(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
//private String email;
}
