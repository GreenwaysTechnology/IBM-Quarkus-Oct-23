package com.ibm.rest.api.parameters.path;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("users")
public class UserResource {

    @GET
    @Path("/{id}")
    public String getUserById(@PathParam("id") Integer id){
        return  id.toString();
    }
}
