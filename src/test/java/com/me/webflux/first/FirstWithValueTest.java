package com.me.webflux.first;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FirstWithValueTest {

    @Test
    public void firstWithValueTest() {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(5)).take(1);
        Flux<Long> flux2 = Flux.interval(Duration.ofSeconds(3)).take(2);

        Flux.firstWithValue(flux1, flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void firstWithValueTestThrowError() {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(5)).take(1);
        Flux<Object> flux2 = Flux.error(RuntimeException::new)
                .mergeWith(Flux.interval(Duration.ofSeconds(3)).take(2));

        Flux.firstWithValue(flux1, flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
