package com.me.webflux.zip;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ZipTestUsingTwoPublisher {

    @Test
    public void zipTestUsingTwoPublisher() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6);

        Flux.zip(flux1, flux2, (f1, f2) -> f1 * f2)
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void zipTestUsingTwoPublisherAndDifferentType() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<String> flux2 = Flux.just("4", "5", "6");

        Flux.zip(flux1, flux2, (f1, f2) -> f1.toString() + f2)
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void zipTestUsingTwoPublisherAndDifferentArgumentCount() {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5);

        Flux.zip(flux1, flux2, (f1, f2) -> f1 * f2)
                .doOnNext(System.out::println)
                .subscribe();
    }
}
