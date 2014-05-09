package com.eguaks.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by jsska on 05.05.2014.
 */

@XmlRootElement
public class Message {

    private static final Logger LOGGER = LoggerFactory.getLogger(Message.class);

    public String id;
    private User from;
    private User to;
    private String header;
    private String message;
    private Date sent;
    private boolean read;

    public Message() {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            id = Integer.toString(random.nextInt());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Failed to create random id");
        }
    }

    public Message(User from, User to, String header, String message, Date sent) {
        this.from = from;
        this.to = to;
        this.header = header;
        this.message = message;
        this.sent = sent;
    }


    @XmlElement
    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @XmlElement
    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @XmlElement(name = "subject")
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @XmlElement(name = "date")
    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    @XmlElement(name = "isRead")
    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }


    @XmlElement
    public String getId(){
        return id;
    }

}
