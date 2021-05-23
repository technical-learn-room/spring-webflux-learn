package com.me.webflux.request_n;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierThenRequestAndThenCancelTest {

    @Test
    public void thenRequestAndThenCancelTest() {
        Flux<String> flux = Flux.just("apple", "banana", "grape", "melon", "mango");

        StepVerifier.create(flux, 1)
                .expectNext("apple")
                .thenCancel()
                .verify();
    }
}
