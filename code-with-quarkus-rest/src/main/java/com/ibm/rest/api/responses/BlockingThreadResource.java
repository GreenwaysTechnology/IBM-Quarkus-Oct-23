package com.ibm.rest.api.responses;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("thread")
public class BlockingThreadResource {

    @GET
    public String runOnWorkerPool() {
        System.out.println("Thread  : " + Thread.currentThread().getName());
        return "Hello";
    }
}
