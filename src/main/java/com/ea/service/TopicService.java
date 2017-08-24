package com.ea.service;

import com.ea.chat.score.*;
import com.ea.chat.score.exceptions.ServiceUnavailableException;
import com.ea.dao.MessagesDao;
import com.ea.chat.score.interfaces.*;
import com.ea.dao.TopicDao;
import com.ea.entity.Message;
import com.ea.entity.Topic;
import com.ea.entity.User;
import com.ea.pubSub.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.Collection;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
@Service
public class TopicService {

    @Autowired
    private TopicDao topicDao;
    private Publisher publisher;
    private MessagesDao messagesDao;
    private IChatScorer chatScorer;

    public Collection<Topic> getAllTopics(){
        return this.topicDao.getAllTopics();


    }

    public int getMessageScore(Message message)throws ServiceUnavailableException{
        return this.chatScorer.score(message.getText());
    }

    public void createTopic(Topic topic)throws JMSException,NamingException {
       publisher.create(topic.getName()+topic.getId(), topic.getName());
        this.topicDao.insertTopicToDb(topic);
    }

    public void createMessage(Message message)throws JMSException,NamingException,ServiceUnavailableException {

        Topic topic1= topicDao.getTopicById(message.getTopicId());
        Boolean notAvail=topic1==null;
       if(notAvail){
           Topic topic=new Topic(message.getTopicId(),"topic"+message.getTopicId());
           this.topicDao.insertTopicToDb(topic);
       }
        Topic topic2= topicDao.getTopicById(message.getTopicId());
        publisher.sendMessage(notAvail?topic2:topic1,message.getText());
        message.setMessageScore(getMessageScore(message));
        this.messagesDao.insertMessageToDb(message);
    }
}
