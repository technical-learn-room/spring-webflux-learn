package com.me.webflux.adapt;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureToMono {

    @Test
    public void test() {
        Mono.fromFuture(CompletableFuture.supplyAsync(() -> "apple"));
    }
}
