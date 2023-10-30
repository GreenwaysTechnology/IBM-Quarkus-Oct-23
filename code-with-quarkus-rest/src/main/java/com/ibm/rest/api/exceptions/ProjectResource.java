package com.ibm.rest.api.exceptions;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Path("project")
public class ProjectResource {

    @GET
    @Path("/{name}")
    public Response getProject(@PathParam("name") String name) {
        if (name.equals("quarkus")) {
            return Response.ok().entity("Quarkus").build();
        } else {
            // throw new RuntimeException("Project Not Found");
            //throw new BadRequestException("Project Not Found Exception");
            throw new WebApplicationException("Project Not Found!!");
        }

    }

    //    class ProjectNotFoundException extends RuntimeException {
//        public ProjectNotFoundException(String message) {
//            super(message);
//        }
//    }
//        class ProjectNotFoundException extends NotFoundException {
//        public ProjectNotFoundException(String message) {
//            super(message);
//        }
    class ProjectNotFoundException extends WebApplicationException {
        public ProjectNotFoundException(String message) {
            super(message);
        }
    }


}
