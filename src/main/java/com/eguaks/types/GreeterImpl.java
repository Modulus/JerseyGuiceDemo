package com.eguaks.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

/**
 * Created by jsska on 10.04.2014.
 */
@Alternative
@Named("greeterv1")
public class GreeterImpl implements Greeter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterImpl.class);

    public Person getGreeting(String name){
        Person person = new Person();
        if (name == null){
            LOGGER.trace("name is null, setting it to John");
            person.setName("John");
        }
        else {
            LOGGER.trace(String.format("Setting name to %s", name));
            person.setName(name);
        }

        person.setMessage(String.format("Hello from Guice, %s. Greeter v1", name));
        LOGGER.trace(String.format("Message set to: %s", person.getMessage()));
        return person;
    }
}
