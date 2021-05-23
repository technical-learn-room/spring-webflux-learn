package com.me.webflux.request_n;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierThenRequestTest {

    @Test
    public void thenRequestTest() {
        Flux<String> flux = Flux.just("apple", "banana", "grape", "melon", "mango");

        StepVerifier.create(flux, 1)
                .expectNext("apple")
                .thenRequest(1)
                .expectNext("banana")
                .thenRequest(2)
                .expectNext("grape", "melon")
                .thenRequest(1)
                .expectNext("mango")
                .verifyComplete();
    }
}
