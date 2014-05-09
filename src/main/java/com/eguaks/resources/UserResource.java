package com.eguaks.resources;


import com.eguaks.data.FakeUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * Created by jsska on 05.05.2014.
 */
@Path("/users")
@RequestScoped
public class UserResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id")String id, @Context Request request){
        Response.ResponseBuilder rb = Response.ok(FakeUserRepository.findOne(id));
        return rb.build();
    }



}
