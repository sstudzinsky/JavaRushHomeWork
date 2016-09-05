package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Stanislav on 04.09.2016.
 */
public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public Message(MessageType messageType) {
        this.type = messageType;
        data = null;
    }

    public Message(MessageType messageType, String data) {
        this.type = messageType;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
