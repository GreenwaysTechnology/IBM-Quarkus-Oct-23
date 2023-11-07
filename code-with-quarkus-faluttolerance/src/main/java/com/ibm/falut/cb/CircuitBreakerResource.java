package com.ibm.falut.cb;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("cb")
public class CircuitBreakerResource {

    @Inject
    CircuitBreakerService circuitBreakerService;
    private AtomicLong counter = new AtomicLong();

    @GET
    @CircuitBreaker(requestVolumeThreshold = 4)
    @Fallback(fallbackMethod = "fallback")
    public List<String> getProducts() {
        maybeFail();
        return circuitBreakerService.getProducts();
    }

    public List<String> fallback() {
        return List.of("Fallback response");
    }

    private void maybeFail() {
        final Long invocationNumber = counter.getAndIncrement();
        if (invocationNumber % 4 > 1) {
            System.out.println(invocationNumber);
            throw new RuntimeException("Service got Failed");
        }
    }

}
