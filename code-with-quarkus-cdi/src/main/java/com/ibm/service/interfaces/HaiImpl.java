package com.ibm.service.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("hai")
public class HaiImpl implements Greeter {
    @Override
    public String sayGreet() {
        return "Hai";
    }
}