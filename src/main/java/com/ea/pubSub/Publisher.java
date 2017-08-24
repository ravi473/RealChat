package com.ea.pubSub;

/**
 * Created by ravikumarpothuganti on 2017-08-15.
 */
import javax.jms.*;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.spi.InitialContextFactory;
import javax.naming.NamingException;


import com.ea.entity.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Publisher {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(Publisher.class);

    private String clientId;
    private Connection connection;
    private Session session;
    private MessageProducer messageProducer;
    private com.ea.entity.Topic topic;

    public void create(String clientId, String topicName) throws JMSException,NamingException {
        this.clientId = clientId;

        //InitialContext context = new InitialContext();

        // create a Connection Factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_BROKER_URL);
//TopicConnectionFactory topicConnectionFactory=(TopicConnectionFactory)jmsTemplate.getConnectionFactory();

        connection = connectionFactory.createConnection();
        connection.setClientID(clientId);

        // create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(topicName);
        //Topic topic = (Topic) context.lookup(topicName);
        // create a MessageProducer for sending messages
        messageProducer = session.createProducer(topic);

    }

    public void closeConnection() throws JMSException {
        connection.close();
    }



    public void sendMessage(com.ea.entity.Topic topic, String message) throws JMSException {
        String clientid=topic.getName()+topic.getId();
        String text = message;

        //this.clientId = clientid;
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_BROKER_URL);

        // create a Connection
        connection = connectionFactory.createConnection();

        // create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create a JMS TextMessage
        TextMessage textMessage = session.createTextMessage(text);

        Topic topic1 = session.createTopic(topic.getName());

        // creating prodcucer
        messageProducer = session.createProducer(topic1);
        // send the message to the topic destination
        messageProducer.send(textMessage);

        LOGGER.debug(clientId + ": sent message with text='{}'", text);
    }
    public void sendName(String firstName, String lastName) throws JMSException {
        String text = firstName + " " + lastName;

        // create a JMS TextMessage
        TextMessage textMessage = session.createTextMessage(text);

        // send the message to the topic destination
        messageProducer.send(textMessage);

        LOGGER.debug(clientId + ": sent message with text='{}'", text);
    }

}
