package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Flowable;
import reactor.core.publisher.Flux;

public class FluxToFlowable {
    public static void main(String[] args) {
        Flowable.fromPublisher(Flux.just("apple", "banana", "grape"));
    }
}
