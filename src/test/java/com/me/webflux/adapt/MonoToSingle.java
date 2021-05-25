package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoToSingle {

    @Test
    public void test() {
        Single.fromPublisher(Mono.just("apple"));
    }
}
