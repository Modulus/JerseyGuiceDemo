package com.eguaks.resources;

import com.eguaks.data.MessageRepository;
import com.google.inject.servlet.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.Serializable;

/**
 * Created by Modulus on 01/05/2014.
 */
@Path("/message")
@SessionScoped
public class MessageResource implements Serializable{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageResource.class);

    @Inject
//    @Named("fakeMessageRepo")
    private MessageRepository messageRepo;

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
