package com.ibm.service;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {

    public String getProduct(){
        return  "Product";
    }
}
