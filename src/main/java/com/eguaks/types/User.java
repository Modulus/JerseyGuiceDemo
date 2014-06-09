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
@XmlType(propOrder = {"id", "name", "created", "caption"})
public class User {
    private String id;
    private String name;
    private String password;
    private LocalDate created;
    private Set<SimpleRole> roles;
    private String caption;

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

    @XmlElement
    public String getCaption(){
        return caption;
    }

    public void setCaption(String caption){
        this.caption =  caption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (caption != null ? !caption.equals(user.caption) : user.caption != null) return false;
        if (created != null ? !created.equals(user.created) : user.created != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        return result;
    }
}
