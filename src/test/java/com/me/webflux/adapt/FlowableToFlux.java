package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FlowableToFlux {

    @Test
    public void test() {
        Flux.from(Flowable.just("apple", "banana", "grape"));
    }
}
