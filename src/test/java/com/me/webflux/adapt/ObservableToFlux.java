package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ObservableToFlux {

    @Test
    public void test() {
        Flux.from(Observable.just("apple", "banana", "grape").toFlowable(BackpressureStrategy.BUFFER));
    }
}
