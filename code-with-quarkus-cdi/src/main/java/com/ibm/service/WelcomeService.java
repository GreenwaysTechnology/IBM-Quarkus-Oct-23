package com.ibm.service;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomeService {

    public Uni<String> getMessage() {
        return Uni.createFrom().item("Hello");
    }
}
