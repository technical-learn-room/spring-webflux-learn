package com.me.webflux.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorHandlingOnErrorContinue {

    @Test
    public void onErrorContinueTest() {
        Flux.just("before data")
                .mergeWith(Mono.error(RuntimeException::new))
                .mergeWith(Mono.just("after data"))
                .log()
                .onErrorContinue((e, o) -> {
                    System.out.println(String.format("error: %s", e));
                    System.out.println(String.format("object: %s", o));
                })
                .doOnNext(System.out::println)
                .subscribe();
    }
}
