package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class MultiStreamProcessing {
    public static void main(String[] args) {
        Multi.createFrom().range(1, 25).onItem().transform(i -> i * 2).subscribe().with(res -> System.out.println(res));

        Multi.createFrom().range(1, 25).filter(i -> i % 2 == 0).subscribe().with(res -> System.out.println(res));

        Multi.createFrom()
                .items(1, 2,2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(item -> item % 2 == 0)
                .select().first(5)
                .select().distinct()
                .subscribe()
                .with(item -> System.out.println(item));
    }
}
