package com.ibm.falut.retry;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RetryService {

    public List<String> getProducts() {
        return List.of("Products1", "Products2", "Products3");
    }
}
