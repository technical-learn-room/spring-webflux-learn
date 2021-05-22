package com.me.webflux.step_verifier;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class StepVerifierIntervalTest {

    @Test
    public void intervalTest() {
        Flux<Long> flux = Flux.interval(Duration.ofSeconds(10)).take(10);
        StepVerifier.create(flux)
                .expectNextCount(10)
                .verifyComplete();
    }
}
