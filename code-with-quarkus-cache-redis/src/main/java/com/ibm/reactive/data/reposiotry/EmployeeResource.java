package com.ibm.reactive.data.reposiotry;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employees")
public class EmployeeResource {

    @Inject
    EmployeeRespository respository;

    @GET
    public Uni<List<Employee>> findAll() {
        return respository.listAll();
    }

    @GET
    @Path("{id}")
    public Uni<Response> getCustomerById(@PathParam("id") Long id) {
        return respository.findById(id).onItem().transform(entity -> {
            if (entity == null) {
                throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
            }
            return Response.ok(entity).status(200).build();
        });
    }

    @POST
    @WithTransaction //Reactive version of transaction annotation
    public Uni<Response> create(Employee employee) {
        //handle error
        if (employee == null || employee.name == null) {
            throw new WebApplicationException("Customer Not Found", 400);
        }
        return respository.persist(employee).onItem().transform(entity ->
                Response.ok().status(201).entity(entity).build()
        );
    }

    @PUT
    @Path("{id}")
    @WithTransaction
    public Uni<Response> update(@PathParam("id") Long id, Employee employee) {
        //handle error
        if (employee == null || employee.name == null) {
            throw new WebApplicationException("Employee Name was not set on request.", 422);
        }
        String query = "city='" + employee.getCity() + "' where id = ?1";
        System.out.println(query);
        return respository.update(query, id).onItem().transform(entity ->
                Response.ok().status(200).entity(entity).build()
        );
    }

    //Delete
    @Path("{id}")
    @DELETE
    @WithTransaction
    public Uni<Response> delete(@PathParam("id") Long id) {
        return respository.deleteById(id).onItem().transform(isDeleted ->
                isDeleted ? Response.ok().status(Response.Status.NO_CONTENT).build()
                        : Response.ok().status(Response.Status.NOT_FOUND).build()
        );
    }
}
