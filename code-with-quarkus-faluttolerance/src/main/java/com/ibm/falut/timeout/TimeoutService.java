package com.ibm.falut.timeout;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TimeoutService {

    public List<String> getProducts() throws InterruptedException {
        //similate delay
        Thread.sleep(5000);
        return List.of("product1","Product2");
    }
}
