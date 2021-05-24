package com.me.webflux.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ErrorHandlingOnErrorResume {

    @Test
    public void onErrorResumeTest() {
        Flux.just("before data")
                .mergeWith(Flux.error(new RuntimeException()))
                .mergeWith(Flux.just("after data"))
                .log()
                .onErrorResume(e -> Flux.just("flux error"))
                .mergeWith(Flux.just("after after data"))
                .doOnNext(System.out::println)
                .subscribe();
    }
}
