package com.eguaks.resources;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.Serializable;

@Path("/greet")
@SessionScoped
public class GreeterResource implements Serializable{

    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterResource.class);

//    @Inject
//    @Named("greeterv1")
//    private Greeter greeter;
//
//    @Inject
//    @Named("greeterv2")
//    private GreeterV2 greeter2;
//
//    @GET
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//
//    public Person getGreetingVersioned(@HeaderParam("x-api-version")Double version, @QueryParam("name")String name, @QueryParam("lastname")String lastname) {
//
//        if(version == null || version <= 1.0 ){
//            LOGGER.info("Getting greeting with version 1.0");
//            return greeter.getGreeting(name);
//        }
//        else {
//            LOGGER.info(String.format("Getting greeting with version %s", version));
//            return greeter2.getGreeting(name, lastname);
//        }
//
//    }

    @RequiresRoles("ADMIN")
    @GET
    @Produces({"text/plain"})
    public String getInfo() {
        LOGGER.info("Getting info message");
        return "Please use request parameters to get data";
    }

}