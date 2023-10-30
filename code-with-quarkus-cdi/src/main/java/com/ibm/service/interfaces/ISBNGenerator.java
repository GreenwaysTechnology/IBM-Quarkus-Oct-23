package com.ibm.service.interfaces;


import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class ISBNGenerator implements NumberGenerator {
    @Override
    public String generateISBNNumber() {
        return "15-343334342" + Math.abs(new Random().nextInt());
    }
}

