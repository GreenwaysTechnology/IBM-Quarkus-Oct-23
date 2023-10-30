package com.ibm.service;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
