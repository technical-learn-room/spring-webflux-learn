package com.me.webflux.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoJustOrEmpty {

    @Test
    public void justOrEmptyTest() {
        Mono.justOrEmpty(null)
                .doOnNext(System.out::println)
                .subscribe();
    }
}
