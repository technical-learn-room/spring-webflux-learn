package com.me.webflux.map_vs_flatmap;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class PublisherFlatMap {

    @Test
    public void publisherFlatMapTest() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .flatMap(f -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(f.toUpperCase());
                })
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void publisherFlatMapTestWithParallel() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .window(1)
                .flatMap(f -> f.map(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.toUpperCase();
                }).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void publisherFlatMapTestWithConcatMap() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .window(1)
                .concatMap(f -> f.map(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.toUpperCase();
                }).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void publisherFlatMapTestWithFlatMapSequential() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .window(1)
                .flatMapSequential(f -> f.map(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.toUpperCase();
                }).subscribeOn(Schedulers.parallel()))
                .doOnNext(System.out::println)
                .blockLast();
    }
}
