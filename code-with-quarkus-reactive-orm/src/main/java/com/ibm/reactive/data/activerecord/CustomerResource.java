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
    //without error handling
//    @GET
//    @Path("{id}")
//    public Uni<Customer> getCustomerById(@PathParam("id") Long id) {
//        return Customer.findById(id);
//    }
    //with error Handling
    @GET
    @Path("{id}")
    public Uni<Response> getCustomerById(@PathParam("id") Long id) {
        return Customer.findById(id).onItem().transform(entity -> {
            if (entity == null) {
                throw new WebApplicationException("Customer with ID Of " + id + "does not  exits", 404);
            }
            return Response.ok(entity).status(200).build();
        });
    }
}
