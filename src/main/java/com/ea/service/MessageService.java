package com.ea.service;

import com.ea.dao.MessagesDao;
import com.ea.dao.UserDao;
import com.ea.entity.Message;
import com.ea.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by ravikumarpothuganti on 2017-08-20.
 */
public class MessageService {

    @Autowired
    private MessagesDao messagesDao;

    public void insertMessage(Message message) {
        this.messagesDao.insertMessageToDb(message);
    }

    public Collection<Message> getTopTenMessages(){
        return this.messagesDao.getTopTenMessages();
    }
}
