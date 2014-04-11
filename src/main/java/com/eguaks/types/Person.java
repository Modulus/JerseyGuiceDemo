package com.eguaks.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JohnSigvald on 11/04/2014.
 */

@XmlRootElement
public class Person {
    private String name;


    private String message;

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement(name = "surname")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
