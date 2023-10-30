package org.acme;

import com.ibm.service.interfaces.Greeter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("hellohai")
public class HelloHaiResource {

    @Inject
    @Named("hai")
    Greeter greeter;

    @GET
    public String sayGreet() {
        return greeter.sayGreet();
    }
}
