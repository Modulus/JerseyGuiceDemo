package com.eguaks.types;

import com.eguaks.core.adapters.LocalDateTypeAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;

/**
 * Created by jsska on 05.05.2014.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder = {"id", "to", "from", "header", "message", "sent", "read"})
public class Message {

    private static final Logger LOGGER = LoggerFactory.getLogger(Message.class);

    private String id;
    private User from;
    private User to;
    private String header;
    private String message;
    private LocalDate sent;
    private boolean read;

    public Message() {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            id = Integer.toHexString(random.nextInt());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Failed to create random id");
        }
    }

    public Message(User from, User to, String header, String message, LocalDate sent) {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            this.id = Integer.toHexString(random.nextInt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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


    @XmlJavaTypeAdapter(value=LocalDateTypeAdapter.class, type= LocalDate.class)
    @XmlElement(name = "date")
    public LocalDate getSent() {
        return sent;
    }

    public void setSent(LocalDate sent) {
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

    protected void setId(String id){
        this.id = id;
    }

}
