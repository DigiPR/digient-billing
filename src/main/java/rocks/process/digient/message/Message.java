/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.message;

import java.util.Date;
import java.util.UUID;

public class Message<T> {

    private String type;
    private final String id = UUID.randomUUID().toString();
    private final Date timestamp = new Date();
    private String businessKey;
    private T payload;

    public Message() {
    }

    public Message(String type, T payload) {
        this.type = type;
        this.payload = payload;
    }

    public Message(String type, T payload, String businessKey) {
        this.type = type;
        this.businessKey = businessKey;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
