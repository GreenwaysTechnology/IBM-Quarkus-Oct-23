package com.ibm.rest.api.context;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.UriInfo;

@Path("context")
public class ContextResource {

    @GET
    @Path("/urlinfo")
    public String getUrlInfo(@Context UriInfo uriInfo) {
        System.out.println(uriInfo.getAbsolutePath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getPathParameters());
        System.out.println(uriInfo.getRequestUri());
        return "Url Info";
    }

    @GET
    @Path("/headers")
    public String getHeaders(@Context HttpHeaders httpHeaders) {
        return httpHeaders.getRequestHeaders().toString();
    }
}
