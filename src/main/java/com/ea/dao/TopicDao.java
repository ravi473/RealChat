package com.ea.dao;

import com.ea.entity.Topic;
import org.springframework.jms.JmsException;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.Collection;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
public interface  TopicDao {

    Collection<Topic> getAllTopics();

    Topic getTopicById(int id);

    void insertTopicToDb(Topic topic) throws JMSException,NamingException;
}
