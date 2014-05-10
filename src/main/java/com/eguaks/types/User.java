package com.eguaks.types;

import com.eguaks.core.LocalDateTypeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Created by jsska on 05.05.2014.
 */
@XmlRootElement(name="user")
public class User {
    private String id;
    private String name;
    private String password;
    private LocalDate created;

    public User(){

    }

    public User(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String id, String name, String password, LocalDate created) {
        this(id, name, password);
        this.created = created;
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

    @XmlJavaTypeAdapter(type=LocalDate.class, value = LocalDateTypeAdapter.class)
    @XmlElement
    public LocalDate getCreated() {
        return created;
    }

//SEE: http://blog.bdoughan.com/2011/05/jaxb-and-joda-time-dates-and-times.html
//    @JsonSerialize(using = CustomDateSerializer.class)
//    @XmlElement
    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
