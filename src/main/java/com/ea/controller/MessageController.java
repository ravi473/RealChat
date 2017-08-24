package com.ea.controller;

import com.ea.chat.score.exceptions.ServiceUnavailableException;
import com.ea.entity.Message;
import com.ea.entity.Topic;
import com.ea.entity.User;
import com.ea.service.MessageService;
import com.ea.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.util.Collection;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
@RestController
@RequestMapping("/Messages")
public class MessageController {
    @Autowired
    private TopicService topicService;
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertMessage(@RequestBody Message message)throws JMSException,NamingException,ServiceUnavailableException {
        topicService.createMessage(message);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Collection<Message> getTopTenMessages(@PathVariable("id") int id){
        //User user=UserService.getUserById(id);
        return messageService.getTopTenMessages();
    }
}
