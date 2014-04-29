package com.eguaks.resources;

import com.eguaks.types.Greeter;
import com.eguaks.types.Person;
import com.eguaks.types.v2.GreeterV2;
import com.google.inject.servlet.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/greet")
@RequestScoped
public class GreeterResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterResource.class);

    @Inject
    @Named("greeterv1")
    private Greeter greeter;

    @Inject
    @Named("greeterv2")
    private GreeterV2 greeter2;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})

    public Person getGreetingVersioned(@HeaderParam("x-api-version")Double version, @QueryParam("name")String name, @QueryParam("lastname")String lastname) {

        if(version == null || version <= 1.0 ){
            LOGGER.info("Getting greeting with version 1.0");
            return greeter.getGreeting(name);
        }
        else {
            LOGGER.info(String.format("Getting greeting with version %s", version));
            return greeter2.getGreeting(name, lastname);
        }

    }

    @GET
    @Produces({"text/plain"})
    public String getInfo() {
        LOGGER.info("Getting info message");
        return "Please use request parameters to get data";
    }

}