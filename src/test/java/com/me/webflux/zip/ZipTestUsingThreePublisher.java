package com.me.webflux.zip;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.List;

public class ZipTestUsingThreePublisher {

    @Test
    public void zipTestUsingThreePublisher() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6);
        Flux<Integer> flux3 = Flux.just(7, 8, 9);

        Flux.zip(flux1, flux2, flux3)
                .map(tuple -> tuple.getT1() + tuple.getT2() + tuple.getT3())
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void zipTestUsingPublisherIterable() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6);
        Flux<Integer> flux3 = Flux.just(7, 8, 9);

        Flux.zip(List.of(flux1, flux2, flux3), flux -> (int) flux[0] + (int) flux[1] + (int) flux[2])
                .doOnNext(System.out::println)
                .subscribe();
    }
}
