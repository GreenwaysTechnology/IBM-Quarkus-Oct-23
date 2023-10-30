package org.acme;

import com.ibm.service.CustomerService;
import com.ibm.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("store")
public class StoreResource {

    @Inject
    ProductService productService;
    @Inject
    CustomerService customerService;

    @GET
    public String getStore() {
        return productService.getProduct() + customerService.getCustomer();
    }
}
