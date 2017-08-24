package com.ea.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ea.entity.Topic;
import com.ea.entity.User;
import com.ea.pubSub.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Repository;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */

@Repository
public class TopicDaoImpl implements TopicDao {

//    @Autowired
//    private Publisher publisher;

    private static Map<Integer, Topic> topics;

    static {

        topics = new HashMap<Integer, Topic>(){

            {
                put(1, new Topic (1, "topic1"));
                put(2, new Topic (2, "topic2"));
                put(3, new Topic (3, "topic3"));
            }
        };
    }

    @Override
    public Collection<Topic> getAllTopics(){
        return this.topics.values();
    }

    @Override
    public Topic getTopicById(int id){

        return this.topics.get(id);
    }

    @Override
    public void insertTopicToDb(Topic topic) throws JMSException,NamingException {

        this.topics.put(topic.getId(), topic);

        //publisher.create(""+topic.getId(), topic.getName());
    }


}
