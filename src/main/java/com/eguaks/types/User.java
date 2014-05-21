package com.eguaks.types;

import com.eguaks.core.adapters.LocalDateTypeAdapter;
import org.apache.shiro.authz.SimpleRole;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by jsska on 05.05.2014.
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder = {"id", "name", "created"})
public class User {
    private String id;
    private String name;
    private String password;
    private LocalDate created;
    private Set<SimpleRole> roles;

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

    public void setCreated(LocalDate created) {
        this.created = created;
    }


    @XmlTransient
    public Set<SimpleRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SimpleRole> roles){
        this.roles = roles;
    }
}
