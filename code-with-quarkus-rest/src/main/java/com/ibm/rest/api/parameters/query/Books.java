package com.ibm.rest.api.parameters.query;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

//GET /books?pages=10
@Path("books")
public class Books {

    @GET
    public String getPages(@QueryParam("pages") @DefaultValue("1") Integer pages) {
        return "Requested Pages are " + pages;
    }
}
