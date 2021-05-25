package com.me.webflux.then;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ThenTest {

    @Test
    public void noArgumentThenTestNoError() {
        Flux.just("apple", "banana", "grape")
                .then()
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void noArgumentThenTestThrowError() {
        Flux.just("apple", "banana", "grape")
                .mergeWith(Mono.error(RuntimeException::new))
                .then()
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void monoArgumentThenTestNoError() {
        Flux.just("apple", "banana", "grape")
                .then(Mono.just("pineapple"))
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void monoArgumentThenTestThrowError() {
        Flux.just("apple", "banana", "grape")
                .mergeWith(Mono.error(RuntimeException::new))
                .then(Mono.just("pineapple"))
                .doOnNext(System.out::println)
                .subscribe();
    }
}
