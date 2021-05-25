package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Flowable;
import reactor.core.publisher.Flux;

public class FlowableToFlux {
    public static void main(String[] args) {
        Flux.from(Flowable.just("apple", "banana", "grape"));
    }
}
