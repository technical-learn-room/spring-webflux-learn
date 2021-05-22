package com.me.webflux.step_verifier;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierSimpleFluxTest {

    @Test
    public void simpleFluxTest() {
        var flux = Flux.just("apple", "banana", "melon");   // 테스트할 데이터 스트림 생성
        StepVerifier.create(flux)                                       // 테스트할 데이터 스트림으로 StepVerifier 생성
                .expectNext("apple")                                    // 다음엔 'apple' 데이터 등장 검증
                .expectNext("banana")                                   // 다음엔 'banana' 데이터 등장 검증
                .expectNext("melon")                                    // 다음엔 'melon' 데이터 등장 검증
                .expectComplete()                                       // 지금까지 모두 성공했는지 검증
                .verify();                                              // 검증 끝
    }
}
