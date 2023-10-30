package com.ibm.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

    public String getCustomer() {
        return "Customer";
    }
}
