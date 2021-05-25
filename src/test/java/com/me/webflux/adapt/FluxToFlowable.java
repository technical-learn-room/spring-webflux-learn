package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxToFlowable {

    @Test
    public void test() {
        Flowable.fromPublisher(Flux.just("apple", "banana", "grape"));
    }
}
