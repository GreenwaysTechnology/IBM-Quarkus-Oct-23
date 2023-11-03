package org.acme;

import com.ibm.rest.client.HelloRestClientService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/greet")
public class GreetingResource {

    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    @Inject
    Vertx vertx;

    WebClient webClient;

    @PostConstruct
    public void init() {
//        create instance of WebClient
        webClient = WebClient.create(vertx, new WebClientOptions().setDefaultHost("localhost").setDefaultPort(8080));
    }

    //REST Client call
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return helloRestClientService.sayHello();
    }

    //vertx client options
    @Path("/vertxclient")
    @GET
    public Uni<String> sayHello() {
        return webClient.get("/hello").send().onItem().transform(HttpResponse::bodyAsString);
    }

}
