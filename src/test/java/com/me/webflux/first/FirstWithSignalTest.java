package com.me.webflux.first;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FirstWithSignalTest {

    @Test
    public void firstWithSignalTest() {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(5)).take(1);
        Flux<Long> flux2 = Flux.interval(Duration.ofSeconds(3)).take(2);

        Flux.firstWithSignal(flux1, flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void firstWithSignalTestThrowError() {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(3)).take(2);
        Flux<Object> flux2 = Flux.error(RuntimeException::new)
                .mergeWith(Flux.interval(Duration.ofSeconds(5)).take(1));

        Flux.firstWithSignal(flux1, flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
