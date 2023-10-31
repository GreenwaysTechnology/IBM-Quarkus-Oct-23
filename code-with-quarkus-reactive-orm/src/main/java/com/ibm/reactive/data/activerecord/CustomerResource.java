package com.ibm.reactive.data.activerecord;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    //List of Customers
    @GET
    public Uni<List<Customer>> findAll() {
        return Customer.listAll();
    }

    //GET BY id
    @GET
    @Path("{id}")
    public Uni<Customer> getCustomerById(@PathParam("id") Long id) {
        return Customer.findById(id);
    }

}
