package com.me.webflux.mono;

/*
public static <T> Mono<T> error(Throwable error)

Description
Create a Mono that terminates with the specified error immediately after being subscribed to.

Type Parameters
T - the reified Subscriber type

Parameters
error - the onError signal

Returns
a failing Mono
 */

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoError {

    @Test
    public void test() {
        Mono.error(new NullPointerException())  // 데이터 스트림에 일으킬 에러를 담음
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
	at com.me.webflux.mono.MonoError.main(MonoError.java:7)
 */