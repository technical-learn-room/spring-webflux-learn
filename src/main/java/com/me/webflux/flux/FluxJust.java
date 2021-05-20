package com.me.webflux.flux;

import reactor.core.publisher.Flux;

/*
@SafeVarargs
public static <T> Flux<T> just(T... data)

Description
Create a Flux that emits the provided elements and then completes.

Type Parameters
T - the emitted data type

Parameters
data - the elements to emit, as a vararg

Returns
a new Flux
 */

public class FluxJust {
    public static void main(String[] args) {
        Flux.just("apple", "banana", "grape", "melon", "mango") // 'apple', 'banana', 'grape', 'melon', 'mango' 라는 데이터를 가진 데이터 스트림을 구축
                .doOnNext(System.out::println)                  // 출력
                .map(f -> "|" + f + "|")                        // 데이터 매핑 (Stream API의 map()과 같음)
                .doOnNext(System.out::println)                  // 다시 출력
                .subscribe();
    }
}

/*
apple
|apple|
banana
|banana|
grape
|grape|
melon
|melon|
mango
|mango|

결과를 보면 하나의 데이터 스트림이 순차적으로 진행되는 것이 아니라
asynchronous 하고 non-blocking 하게 데이터 스트림이 진행된다는 것을 알 수 있다.
따라서 데이터 스트림 속 데이터는 각각 독립된 매개체이다.
 */