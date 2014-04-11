package com.eguaks.types.v2;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

/**
 * Created by jsska on 10.04.2014.
 */
@Alternative
@Named("greeterv2")
public class GreeterVersion2Impl implements GreeterV2 {

    @Override
    public PersonVersion2Impl getGreeting(String name){
        PersonVersion2Impl person = new PersonVersion2Impl();
        if (name == null){
            person.setName("John");
        }
        else {
            person.setName(name);
        }

        person.setMessage(String.format("Hello from Guice, %s. Greeter v2", name));
        return person;
    }

    @Override
    public PersonVersion2Impl getGreeting(String firstname, String lastname) {
        PersonVersion2Impl person = new PersonVersion2Impl();
        if(firstname == null || lastname == null){
            person.setName("John");
            person.setLastName("Doe");
        }
        else {
            person.setName(firstname);
            person.setLastName(lastname);
        }
        person.setMessage(String.format("Hello from Guice, %s %s. Greeter v2", firstname, lastname));
        return person;
    }
}
