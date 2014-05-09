package com.eguaks.resources;

import com.google.inject.servlet.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by Modulus on 01/05/2014.
 */
@Path("/message")
@SessionScoped
public class MessageResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageResource.class);

    @Context
    SecurityContext securityContext;

    @POST
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_FORM_URLENCODED})
    public String echo(@FormParam("message") String message){
        LOGGER.debug("Inside");
        return "ahahahah";
    }

    @GET
    public String test(){
        return "Get called";
    }

}
