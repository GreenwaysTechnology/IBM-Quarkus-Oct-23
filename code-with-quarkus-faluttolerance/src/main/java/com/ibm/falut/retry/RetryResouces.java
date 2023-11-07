package com.ibm.falut.retry;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Path("retry")
public class RetryResouces {

    @Inject
    RetryService retryService;
    private AtomicLong counter = new AtomicLong();
    private float faileRatio = 0.5f;

    @GET
    @Retry(maxRetries = 3, retryOn = RuntimeException.class)
    @Fallback(fallbackMethod = "fallbackProducts")
    public List<String> getProducts() throws InterruptedException {
        final Long invoicationNumber = counter.getAndIncrement();
        maybeFail(String.format("Retry Resouce#getProducts invocation %d failed", invoicationNumber));
        return retryService.getProducts();
    }

    public List<String> fallbackProducts() {
        return List.of("Fallback products");
    }

    private void maybeFail(String failureMessage) {
        if (new Random().nextFloat() < faileRatio) {
            System.out.println(failureMessage);
            throw new RuntimeException("Resouce Failed");
        }

    }

}
