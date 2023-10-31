package com.ibm.activerecord.resource;

import com.ibm.activerecord.entity.Customer;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    //CURD operations
    @GET
    public List<Customer> findAll() {
        return Customer.listAll();
    }

    @GET
    @Path("{id}")
    public Customer findById(@PathParam("id") Integer id) {
        Customer customer = Customer.findById(id);
        if (customer == null) {
            throw new WebApplicationException("Customer with Id of " + id + "does not exits");
        }
        return customer;
    }

    //Post
    @POST
    @Transactional
    public Response create(Customer customer) {
        if (customer.id != null) {
            throw new WebApplicationException("Id was invalidly set on Request", 422);
        }
        customer.persist();
        return Response.ok(customer).status(201).build();
    }
    //Update

    @PUT
    @Path("{id}")
    @Transactional
    public Customer update(@PathParam("id") Long id, Customer customer) {
        if (customer.name == null) {
            throw new WebApplicationException("Customer Name was not set on request " + 422);
        }
        Customer customerEntity = Customer.findById(id);
        if (customerEntity == null) {
            throw new WebApplicationException("Customer with ID Of " + id + "does not  exits", 404);
        }
        //update logic
        customerEntity.name = customer.name;
        customerEntity.city = customer.city;
        return customerEntity;
    }
    //delete record
    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        Customer customer = Customer.findById(id);
        if(customer==null){
            throw new WebApplicationException("Customer with ID Of " + id + "does not  exits", 404);
        }
        customer.delete();
        return Response.status(204).build();
    }
}
