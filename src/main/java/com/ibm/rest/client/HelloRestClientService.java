package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
//@RegisterRestClient
@RegisterRestClient(configKey = "hello-api")
public interface HelloRestClientService {
    //CURD OPERATIONS of call
    @GET
    Uni<String> sayHello();
}
