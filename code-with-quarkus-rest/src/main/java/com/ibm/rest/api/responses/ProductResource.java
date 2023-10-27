package com.ibm.rest.api.responses;

import com.ibm.rest.api.entity.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public Response getProducts() {
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00)

        );
        return Response.ok().entity(products).status(200).header("company", "ebay")
                .build();
    }

    @DELETE
    public void remove() {
        System.out.println("remove");
    }
}
