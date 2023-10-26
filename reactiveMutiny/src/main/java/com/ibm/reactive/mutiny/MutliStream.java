package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class MutliStream {
    public static void main(String[] args) {
        Multi.createFrom().items(1,2,3,4,5,6).subscribe().with(item-> System.out.println(item));
    }
}
