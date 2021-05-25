package com.me.webflux.adapt;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureToMono {
    public static void main(String[] args) {
        Mono.fromFuture(CompletableFuture.supplyAsync(() -> "apple"));
    }
}
