package com.ibm.rest.api.responses;

import com.ibm.rest.api.entity.Product;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.util.List;

@Path("reactive")
public class ReactiveNonBlockingResource {

    //Simple String
    @GET
    @Path("/name")
    public Uni<String> getName() {
        System.out.println("Thread =>  " + Thread.currentThread().getName());
        return Uni.createFrom().item("Hello");
    }

    @GET
    @Path("/products")
    public Uni<List<Product>> getProducts() {
        System.out.println("getProducts Thread =>  " + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00)

        );
        return Uni.createFrom().item(products);
    }

    @GET
    @Path("/products/response")
    public RestResponse<List<Product>> getProductsResponse() {
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00)

        );
        return ResponseBuilder.ok(products).build();
    }
}
