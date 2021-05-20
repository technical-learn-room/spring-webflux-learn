package com.me.webflux.mono;

import reactor.core.publisher.Mono;

/*
public final Mono<T> or(Mono<? extends T> other)

Description
Emit the first available signal from this mono or the other mono.

Parameters
other - the racing other Mono to compete with for the signal

Returns
a new Mono
 */

public class MonoOr {
    public static void main(String[] args) {
        var mono1 = Mono.just("apple");
        var mono2 = Mono.just("banana");
        mono1.or(mono2)
                .doOnNext(System.out::println)
                .subscribe();
    }
}

/*
apple
 */