package com.eguaks.resources;

import com.eguaks.data.MessageRepository;
import com.eguaks.data.UserRepository;
import com.eguaks.types.Message;
import com.eguaks.types.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.xml.ws.spi.http.HttpContext;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Modulus on 01/05/2014.
 */

@Path("/messages")
@SessionScoped
public class MessageResource implements Serializable{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageResource.class);

    @Inject
    @Named("fakeMessageRepo")
    private MessageRepository messageRepo;

    @Inject
    @Named("fakeUserRepo")
    private UserRepository userRepository;

    @Context
    SecurityContext securityContext;

    @RequiresAuthentication
    @PUT
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_FORM_URLENCODED})
    public Response sendMessage(@FormParam("header") String header ,
                                @FormParam("message") String message,
                                @FormParam("to") String to,
                                @Context HttpServletRequest context){
        LOGGER.debug("Inside");

        User currentUser = (User)SecurityUtils.getSubject().getPrincipal();
        if(currentUser != null && to != null){
            if(userRepository.findOne(currentUser.getId()) != null && userRepository.findOne(to.toString()) != null){
                User recipient = userRepository.findOne(to.toString());
                Message msg = new Message(currentUser, recipient, header, message, LocalDate.now());

                messageRepo.sendMessage(msg);
                return Response.ok().build();

            }
        }
        return Response.noContent().build();
    }

    @RequiresAuthentication
    @GET
    @Path("/{userid}")
    @Consumes(value = MediaType.TEXT_PLAIN)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Message> test(@PathParam("userid")String userid/*, @Context HttpContext httpContext*/){
        LOGGER.debug(String.format("Trying to find messages for user with id %s", userid));
        List<Message> messages =  messageRepo.getAll(userid);
        if(messages != null){
            LOGGER.debug(String.format("Found %s message(s)", messages.size()));
        }
        else {
            LOGGER.debug(String.format("Found no messages for user with id %s", userid));
        }
        return messages;

    }

    @RequiresAuthentication
    @GET
    @Path("/{userid}/{messageid}")
    @Consumes(value = MediaType.TEXT_PLAIN)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Message getMessageForUser(@PathParam("userid")String userid, @PathParam("messageid")String messageid){
        Message message = messageRepo.findOne(userid, messageid);

        return message;
    }



//    @HeaderParam("X-CustomHeader")
//    public void setHeader(String header){
//        String x = "123213213213";
//    }
}
