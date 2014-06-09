package com.eguaks.resources;


import com.eguaks.data.UserRepository;
import com.eguaks.types.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by jsska on 05.05.2014.
 */
@Path("/users")
@RequestScoped
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserRepository userRepo;



    @Inject
    public void setUserRepository(@Named("fakeUserRepo")UserRepository userRepository){
        this.userRepo = userRepository;
    }

    @RequiresAuthentication
    @GET
    @Path("{id}")
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUserById(@PathParam("id") String id, @Context Request request){
        User user = userRepo.findOne(id);
        LOGGER.info(String.format("Found user with id %s", user.getId()));

        return user;
    }

    @RequiresAuthentication
    @GET
    @Path("/all")
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getAll(){
        return userRepo.getAll();
    }

    @RequiresRoles("ADMIN")
    @DELETE
    @Produces({"text/plain"})
    public String getInfo() {
        LOGGER.info("Getting info message");
        return "Please use request parameters to get data";
    }

    @RequiresAuthentication
    @POST
    @Path("{id}/caption")
    public Response changeCaption(@FormParam("caption") String caption, @PathParam("id") String id){
        if(id != null && userRepo.findOne(id) != null){
            User current = userRepo.findOne(id);
            User actual = (User)SecurityUtils.getSubject().getPrincipal();
            if(current.equals(actual)){
                actual.setCaption(caption);
                userRepo.update(actual);
                return Response.ok().build();
            }
        }
        return Response.noContent().build();
    }



}
