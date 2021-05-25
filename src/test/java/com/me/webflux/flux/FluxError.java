package com.me.webflux.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/*
public static <T> Flux<T> error(Throwable error)

Description
Create a Flux that terminates with the specified error immediately after being subscribed to.

Type Parameters
T - the reified type of the target Subscriber

Parameters
error - the error to signal to each Subscriber

Returns
a new failing Flux
 */

public class FluxError {

    @Test
    public void test() {
        Flux.error(new NullPointerException())  // 데이터 스트림에 일으킬 에러를 담음
                .subscribe();                   // 구독시 에러를 발생시킴
        /*
        에러를 안 일으키기 위해서는 doOnError()를 이용하면 에러 발생시 처리할 행동을 Consumer 로 작성
         */
    }
}

/*
14:57:26.195 [main] ERROR reactor.core.publisher.Operators - Operator called default onErrorDropped
reactor.core.Exceptions$ErrorCallbackNotImplemented: java.lang.NullPointerException
Caused by: java.lang.NullPointerException: null
	at com.me.webflux.flux.FluxError.main(FluxError.java:7)
 */