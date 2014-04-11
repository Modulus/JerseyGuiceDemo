package com.eguaks.types.v2;

import com.eguaks.types.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JohnSigvald on 10/04/2014.
 */
@XmlRootElement
public class PersonVersion2Impl extends Person {

    private String lastName;

    @XmlElement(name = "firstname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
