package com.ibm.rest.api;


import jakarta.ws.rs.*;

@Path("/customers")
public class CustomerResource {

    //CURD Operations
    @GET
    public String getCustomers() {
        return "Customers";
    }

    @POST
    public String addCustomer() {
        return "Customers add";
    }

    @PUT
    public String updateCustomer() {
        return "Update customers";
    }

    @DELETE
    @Path("/remove")
    public String removeCustomer() {
        return "Remove Customers";
    }
}
