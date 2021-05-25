package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import reactor.core.publisher.Flux;

public class ObservableToFlux {
    public static void main(String[] args) {
        Flux.from(Observable.just("apple", "banana", "grape").toFlowable(BackpressureStrategy.BUFFER));
    }
}
