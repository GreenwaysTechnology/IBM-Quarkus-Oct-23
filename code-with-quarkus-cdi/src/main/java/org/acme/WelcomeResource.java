package org.acme;

import com.ibm.service.WelcomeService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("welcome")
public class WelcomeResource {

    //private WelcomeService welcomeService;
    WelcomeService welcomeService;

    public WelcomeResource() {
    }

    @Inject
    public WelcomeResource(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    public WelcomeService getWelcomeService() {
        return welcomeService;
    }

    //@Inject
    public void setWelcomeService(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GET
    public Uni<String> sayHello() {
        return welcomeService.getMessage();
    }
}
