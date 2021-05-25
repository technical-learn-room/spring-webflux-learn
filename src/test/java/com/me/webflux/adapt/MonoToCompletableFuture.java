package com.me.webflux.adapt;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoToCompletableFuture {

    @Test
    public void test() {
        Mono.just("apple").toFuture();
    }
}
