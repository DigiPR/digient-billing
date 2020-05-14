/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.billing.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import rocks.process.digient.billing.channel.ProducerChannel;
import rocks.process.digient.message.Message;

@Component
@EnableBinding(ProducerChannel.class)
public class MessageSender {
    @Autowired
    @Output(ProducerChannel.MAILING)
    private MessageChannel mailingChannel;

    @Autowired
    @Output(ProducerChannel.MDM)
    private MessageChannel mdmChannel;

    public void sendMailing(Message<?> message) {
        mailingChannel.send(MessageBuilder.withPayload(message).setHeader("type", message.getType()).build());
    }

    public void sendMDM(Message<?> message) {
        mdmChannel.send(MessageBuilder.withPayload(message).setHeader("type", message.getType()).build());
    }
}
