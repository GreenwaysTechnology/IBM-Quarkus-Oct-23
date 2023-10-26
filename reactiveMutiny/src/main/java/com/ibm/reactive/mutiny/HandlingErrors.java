package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class HandlingErrors {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("Something went wrong"))
                .onFailure().recoverWithItem("fallback")
                .subscribe().with(err-> System.out.println(err));
    }
}
