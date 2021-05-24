package com.me.webflux.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ErrorHandlingOnErrorContinue {

    @Test
    public void onErrorContinueTest() {
        Flux.just("before data")
                .mergeWith(Flux.error(RuntimeException::new))
                .mergeWith(Flux.just("after data"))
                .log()
                .onErrorContinue((e, o) -> {
                    System.out.println(String.format("error: %s", e));
                    System.out.println(String.format("object: %s", o));
                })
                .mergeWith(Flux.just("after after data"))
                .doOnNext(System.out::println)
                .subscribe();
    }
}
