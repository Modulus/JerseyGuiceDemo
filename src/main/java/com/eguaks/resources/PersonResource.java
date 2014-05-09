package com.eguaks.resources;

import com.eguaks.types.Person;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by JohnSigvald on 09/05/2014.
 */
@SessionScoped
@Path("/users")
@Named("personResource")
public class PersonResource {

    @POST
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_FORM_URLENCODED})
    public Person getUser(@FormParam("id") String id){
        return new Person();
    }
}
