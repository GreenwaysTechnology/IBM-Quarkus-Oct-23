package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class Transformation {
    public static void main(String[] args) {
        Uni.createFrom().item("hello")
                .onItem()
                .transform(item-> item + " Subramanian")
                .onItem()
                .transform(String::toUpperCase)
                .subscribe().with(res->{
                    System.out.println(res);
                });

    }
}
