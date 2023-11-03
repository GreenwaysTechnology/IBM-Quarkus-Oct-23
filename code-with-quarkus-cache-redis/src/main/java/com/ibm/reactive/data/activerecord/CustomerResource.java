package com.ibm.reactive.data.activerecord;

import io.quarkus.cache.CacheResult;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    //List of Customers
    @GET
    @CacheResult(cacheName = "customers")
    public Uni<List<Customer>> findAll() {
        System.out.println("GetCustomer By id is called");
        return Customer.listAll();
    }

    //GET BY id
    //without error handling
    @GET
    @Path("{id}")
    @CacheResult(cacheName = "customerById")
    public Uni<Customer> getCustomerById(@PathParam("id") Long id) {
        return Customer.findById(id);
    }
    //with error Handling
   // @GET
//    @Path("{id}")
////    @CacheResult(cacheName = "customerById")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Uni<Response> getCustomerById(@PathParam("id") Long id) {
//        System.out.println("Get Customer By id");
//        return Customer.findById(id).onItem().transform(entity -> {
//            if (entity == null) {
//                throw new WebApplicationException("Customer with ID Of " + id + "does not  exits", 404);
//            }
//            return Response.ok(entity).status(200).build();
//        });
//    }

    //POST
    @POST
    public Uni<Response> create(Customer customer) {
        //handle error
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("Customer Not Found", 400);
        }
        return Panache.withTransaction(customer::persist)
                .replaceWith(Response.ok(customer)
                        .status(Response.Status.CREATED).build());
    }

    @PUT
    @Path("{id}")
    public Uni<Response> update(@PathParam("id") Long id, Customer customer) {
        //handle error
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("Customer Name was not set on request.", 422);
        }
        return Panache.withTransaction(() ->
                Customer.<Customer>findById(id).onItem().ifNotNull().invoke(entity -> {
                            entity.city = customer.city;
                            entity.name = customer.name;
                        })
                        .onItem().ifNotNull().transform(entity -> Response.ok(entity).status(200).build())
                        .onItem().ifNull().continueWith(Response.ok().status(Response.Status.NOT_FOUND)::build));
    }

    //Delete
    @Path("{id}")
    @DELETE
    public Uni<Response> delete(@PathParam("id") Long id) {
        return Panache.withTransaction(() ->
                Customer.deleteById(id).map(isDeleted ->
                        isDeleted ? Response.ok().status(Response.Status.NO_CONTENT).build()
                                : Response.ok().status(Response.Status.NOT_FOUND).build()
                )
        );
    }
}