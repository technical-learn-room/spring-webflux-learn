package com.me.webflux.merge;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxConcat {

    @Test
    public void toMergeUsingConcat() {
        Mono<String> mono1 = Mono.just("가");
        Mono<String> mono2 = Mono.just("나");
        Mono<String> mono3 = Mono.just("다");

        Flux.concat(mono1, mono2, mono3)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
