package com.ibm.repository;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employees")
public class EmployeeRepositoryResource {
    //CURD operations
    @Inject
    EmployeeRepository employeeRepository;

    @GET
    public List<Employee> findAll() {
        return employeeRepository.listAll();
    }

    @GET
    @Path("{id}")
    public Employee findById(@PathParam("id") Long id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        return employee;
    }

    //post
    @POST
    @Transactional
    public Response create(Employee employee) {
        if (employee.id != null) {
            throw new WebApplicationException("ID was invalidly set on request", 404);
        }
        employeeRepository.persist(employee);
        return Response.ok(employee).status(201).build();
    }

    //update
    @PUT
    @Path("{id}")
    @Transactional
    public Employee update(@PathParam("id") Long id, Employee employee) {
        if (employee.name == null || employee.city == null) {
            throw new WebApplicationException("Employee Name or city was not set on request" + 422);
        }
        Employee employeeEnity = employeeRepository.findById(id);
        if (employeeEnity == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        employeeEnity.name = employee.name;
        employeeEnity.city = employee.city;
        return employeeEnity;
    }

    @Path("{id}")
    @Transactional
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        Employee employeeEnity = employeeRepository.findById(id);
        if (employeeEnity == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        employeeRepository.delete(employeeEnity);
        return Response.ok().status(204).build();
    }

}

