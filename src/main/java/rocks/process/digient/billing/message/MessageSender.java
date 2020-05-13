/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.billing.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import rocks.process.digient.message.Message;

@Component
@EnableBinding(Source.class)
public class MessageSender {
    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel messageChannel;

    public void send(Message<?> message) {
        messageChannel.send(MessageBuilder.withPayload(message).setHeader("type", message.getType()).build());
    }
}
