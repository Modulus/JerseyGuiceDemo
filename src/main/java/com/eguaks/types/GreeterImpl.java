package com.eguaks.types;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

/**
 * Created by jsska on 10.04.2014.
 */
@Alternative
@Named("greeterv1")
public class GreeterImpl implements Greeter {

    public Person getGreeting(String name){
        Person person = new Person();
        if (name == null){
            person.setName("John");
        }
        else {
            person.setName(name);
        }

        person.setMessage(String.format("Hello from Guice, %s. Greeter v1", name));
        return person;
    }
}
