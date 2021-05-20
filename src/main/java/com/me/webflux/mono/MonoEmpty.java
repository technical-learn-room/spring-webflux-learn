package com.me.webflux.mono;

import reactor.core.publisher.Mono;

/*
public static <T> Mono<T> empty()

Description
Create a Mono that completes without emitting any item.

Type Parameters
T - the reified Subscriber type

Returns
a completed Mono
 */

public class MonoEmpty {
    public static void main(String[] args) {
        Mono.empty()                                // 빈 데이터 스트림 생성
                .doOnNext(System.out::println)      // 데이터 스트림에게 다음 행동을 지시 :: println, but 데이터 스트림이 비어 있으므로 작동하지 않음
                .subscribe();                       // 모든 요청은 구독을 해야 동작
    }
}
