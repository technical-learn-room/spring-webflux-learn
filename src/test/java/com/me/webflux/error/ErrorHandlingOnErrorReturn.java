package com.me.webflux.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ErrorHandlingOnErrorReturn {

    @Test
    public void onErrorReturnTest() {
        Flux.just("before data")
                .mergeWith(Flux.error(new RuntimeException()))
                .mergeWith(Flux.just("after data"))
                .log()
                .onErrorReturn("flux error")
                .mergeWith(Flux.just("after after data"))
                .doOnNext(System.out::println)
                .subscribe();
    }
}
