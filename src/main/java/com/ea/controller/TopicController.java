package com.ea.controller;

import com.ea.entity.Topic;
import com.ea.entity.User;
import com.ea.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.Collection;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */

@RestController
@RequestMapping("/Topics")
public class TopicController {

    @Autowired
    private TopicService topicService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTopic(@RequestBody Topic topic)throws JMSException,NamingException {
        topicService.createTopic(topic);
    }

}
