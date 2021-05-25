package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

public class FluxToObservable {
    public static void main(String[] args) {
        Observable.fromPublisher(Flux.just("apple", "banana", "grape"));
    }
}
