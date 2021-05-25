package com.me.webflux.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/*
public static <T> Flux<T> empty()

Description
Create a Flux that completes without emitting any item.

Type Parameters
T - the reified type of the target Subscriber

Returns
an empty Flux
 */

public class FluxEmpty {

    @Test
    public void test() {
        Flux.empty()                                // 빈 데이터 스트림 생성
                .doOnNext(System.out::println)      // 데이터 스트림에게 다음 행동을 지시 :: println, but 데이터 스트림이 비어 있으므로 작동하지 않음
                .subscribe();                       // 모든 요청은 구독을 해야 동작
    }
}