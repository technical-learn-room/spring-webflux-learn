package com.me.webflux.merge;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Comparator;

public class FluxConcatWith {

    @Test
    public void toMergeUsingConcatWith() {
        Flux<Double> flux1 = Flux.interval(Duration.ofSeconds(1))
                .take(3)
                .map(Double::valueOf);
        Flux<Double> flux2 = Flux.just(0.5, 1.5, 2.5, 3.5);

        flux1.concatWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
