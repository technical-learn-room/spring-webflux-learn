package com.me.webflux.mono;

import reactor.core.publisher.Mono;

/*
public static <T> Mono<T> just(T data)

Description
Create a new Mono that emits the specified item, which is captured at instantiation time.

Type Parameters
T - the type of the produced item

Parameters
data - the only item to onNext

Returns
a Mono.
 */

public class MonoJust {
    public static void main(String[] args) {
        Mono.just("apple")                      // 'apple' 데이터를 가진 데이터 스트림을 구축
                .doOnNext(System.out::println)  // 출력
                .map(f -> "|" + f + "|")        // 데이터 매핑 (Stream API의 map()과 같음)
                .doOnNext(System.out::println)  // 다시 출력
                .subscribe();
    }
}

/*
apple
|apple|
 */