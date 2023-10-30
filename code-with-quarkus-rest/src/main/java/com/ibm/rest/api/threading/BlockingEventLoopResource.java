package com.ibm.rest.api.threading;

import com.ibm.rest.api.entity.Product;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;
import java.util.List;

@Path("blocking")
public class BlockingEventLoopResource {

    @GET
    @Blocking //safely delegate the work to worker thread...
    public Uni<List<Product>> getProduct() throws InterruptedException {
        System.out.println("Get Product => " + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));
        //write some code which blocks the event loop thread
        Thread.sleep(6000);
        return Uni.createFrom().item(products);
    }

    @GET
    @Path("/reactiveschduler")
    public Uni<List<Product>> getReactiveProducts() throws InterruptedException {
        System.out.println("getReactiveProducts => " + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));
        return Uni.createFrom().item(products).onItem().delayIt().by(Duration.ofSeconds(6));
    }

}
