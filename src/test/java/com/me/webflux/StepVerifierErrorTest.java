package com.me.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierErrorTest {

    @Test
    public void errorTest() {
        var flux = Flux.just("apple")
                .mergeWith(Flux.error(new NullPointerException()));    // 2번째 데이터가 에러를 일으키는 데이터 스트림 생성

        StepVerifier.create(flux)                                      // StepVerifier 생성
                .expectNext("apple")                                   // 'apple' 데이터가 등장한다는 것을 검증
                .expectError(NullPointerException.class)               // 'NullPointerException' 이 발생한다는 것을 검증
                .verify();                                             // 검증 완료
    }
}
