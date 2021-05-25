package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxToObservable {

    @Test
    public void test() {
        Observable.fromPublisher(Flux.just("apple", "banana", "grape"));
    }
}
