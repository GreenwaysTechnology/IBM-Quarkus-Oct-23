package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class ErrorEvent {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("something went wrong"))
                .subscribe().with(err -> System.out.println(err));
    }
}
