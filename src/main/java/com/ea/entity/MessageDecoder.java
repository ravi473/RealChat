package com.ea.entity;

/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Message decode(final String textMessage) throws DecodeException {
        Message message = new Message();
        JsonObject jsonObject = Json.createReader(new StringReader(textMessage)).readObject();
        message.setId(jsonObject.getInt("id"));
        message.setText(jsonObject.getString("text"));
        message.setUserName(jsonObject.getString("userName"));
        message.setMessageScore(jsonObject.getInt("messageScore"));
        return message;
    }

    @Override
    public boolean willDecode(final String s) {
        return true;
    }

}

