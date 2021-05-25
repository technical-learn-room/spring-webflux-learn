package com.me.webflux.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/*
public static <T> Mono<T> never()

Description
Return a Mono that will never signal any data, error or completion signal, essentially running indefinitely.

Type Parameters
T - the Subscriber type target

Returns
a never completing Mono
 */

public class FluxNever {

    @Test
    public void test() {
        Flux.never()
                .mergeWith(Flux.error(new RuntimeException()))
                .doOnNext(System.out::println)
                .subscribe();
    }
}

/*
개념상으로는 에러도 발생하지 않고 데이터도 처리하지 않아야 할 것 같은데
에러도 발생시키고 데이터도 처리한다는 것이 모순이다.
내가 아직 잘 이해하지 못한 부분이 있는 것 같다.

15:36:03.160 [main] ERROR reactor.core.publisher.Operators - Operator called default onErrorDropped
reactor.core.Exceptions$ErrorCallbackNotImplemented: java.lang.RuntimeException
Caused by: java.lang.RuntimeException: null
	at com.me.webflux.flux.FluxNever.main(FluxNever.java:7)
 */