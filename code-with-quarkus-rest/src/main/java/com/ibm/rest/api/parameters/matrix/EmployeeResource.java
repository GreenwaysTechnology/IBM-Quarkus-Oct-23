package com.ibm.rest.api.parameters.matrix;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;

//localhost:8080/employees/info;project=ecommerce;client=ebay
@Path("employees")
public class EmployeeResource {

    @GET
    @Path("/info")
    public String getEmployee(@MatrixParam("project") String project, @MatrixParam("client") String client) {
        return project + " " + client;
    }
}
