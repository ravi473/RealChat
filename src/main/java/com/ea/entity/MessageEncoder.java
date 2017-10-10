package com.ea.entity;

/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */
import com.ea.utils.JsonUtil;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final Message message) throws EncodeException {
        return JsonUtil.formatMessage(message.getText(), message.getUserName());
    }

}

