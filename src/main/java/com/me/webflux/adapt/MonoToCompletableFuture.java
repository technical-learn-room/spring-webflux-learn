package com.me.webflux.adapt;

import reactor.core.publisher.Mono;

public class MonoToCompletableFuture {
    public static void main(String[] args) {
        Mono.just("apple").toFuture();
    }
}
