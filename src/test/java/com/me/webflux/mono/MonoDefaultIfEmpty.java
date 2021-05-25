package com.me.webflux.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoDefaultIfEmpty {

    @Test
    public void defaultIfEmptyTest() {
        Mono.empty()
                .defaultIfEmpty("apple")
                .doOnNext(System.out::println)
                .subscribe();
    }
}
