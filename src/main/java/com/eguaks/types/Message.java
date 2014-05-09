package com.eguaks.types;

import java.util.Date;

/**
 * Created by jsska on 05.05.2014.
 */
public class Message {
    private User from;
    private User to;
    private String header;
    private String message;
    private Date sent;
    private boolean read;

    public Message() {

    }

    public Message(User from, User to, String header, String message, Date sent) {
        this.from = from;
        this.to = to;
        this.header = header;
        this.message = message;
        this.sent = sent;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
