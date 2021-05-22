package com.me.webflux.merge;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxMergeWith {

    @Test
    public void toMergeUsingMergeWith() {
        Flux<String> flux1 = Flux.interval(Duration.ofSeconds(1))
                .take(3)
                .map(String::valueOf);
        Flux<String> flux2 = Flux.just("가", "나", "다");

        flux1.mergeWith(flux2)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
