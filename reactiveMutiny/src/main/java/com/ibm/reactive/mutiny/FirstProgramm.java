package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class FirstProgramm {
    public static void main(String[] args) {
        //create publisher,emit,and subscribe
        Uni.createFrom().item("hello").subscribe().with(item-> System.out.println(item));
    }
}
