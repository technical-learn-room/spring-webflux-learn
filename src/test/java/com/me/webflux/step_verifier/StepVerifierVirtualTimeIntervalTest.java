package com.me.webflux.step_verifier;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class StepVerifierVirtualTimeIntervalTest {

    @Test
    public void virtualTimeIntervalTest() {
        StepVerifier.withVirtualTime(() -> Flux.interval(Duration.ofSeconds(10)).take(10))
                .thenAwait(Duration.ofSeconds(50))
                .expectNextCount(5)
                .thenAwait(Duration.ofSeconds(30))
                .expectNextCount(3)
                .thenAwait(Duration.ofSeconds(20))
                .expectNextCount(2)
                .verifyComplete();
    }
}

/*
실제로는 100초가 걸리는 작업이지만,
withVirtualTime() 메소드를 이용해서 Virtual Time 을 통해 데이터 스트림을 처리하기 때문에
훨씬 빠른 시간에 테스트 코드를 성공할 수 있었다.
 */
