package com.ea.services;

import com.ea.dao.MessagesDao;
import com.ea.entity.Message;

/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */
public class Service {

    public void verifyMessage(Message message) {
        MessagesDao messagesDao = new MessagesDao();
        boolean ifNotExist=messagesDao.getTopic(message.getTopic())==null;
        if(ifNotExist) {
            Message message1 = new Message();
            messagesDao.insertMessageToDb(message1);
        }

    }
}
