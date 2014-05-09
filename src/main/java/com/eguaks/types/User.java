package com.eguaks.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by jsska on 05.05.2014.
 */

@XmlRootElement(name="user")
public class User {
    private String id;
    private String name;
    private String password;

    public User(){

    }

    public User(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @XmlElement(name = "ident")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
