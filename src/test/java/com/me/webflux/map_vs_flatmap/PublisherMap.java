package com.me.webflux.map_vs_flatmap;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/*
public final <V> Flux<V> map(Function<? super T,? extends V> mapper)

Descriptions:
Transform the items emitted by this Flux by applying a synchronous function to each item.

Type Parameters:
V - the transformed type

Error Mode Support:
This operator supports resuming on errors (including when fusion is enabled).
Exceptions thrown by the mapper then cause the source value to be dropped
and a new element (request(1)) being requested from upstream.

Parameters:
mapper - the synchronous transforming Function

Returns:
a transformed Flux
 */

public class PublisherMap {

    @Test
    public void publisherMapTest() throws InterruptedException {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .map(f -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return f.toUpperCase();
                })
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void publisherMapTestWithFakeAsync() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .map(f -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(f.toUpperCase());
                }).subscribeOn(Schedulers.parallel())
                .doOnNext(System.out::println)
                .blockLast();
    }

    @Test
    public void publisherMapTestWithAsync() {
        Flux.just("apple", "banana", "melon", "mango", "grape", "strawberry", "eggplant", "watermelon", "kiwi")
                .window(1)
                .map(f -> f.map(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s.toUpperCase();
                }).subscribeOn(Schedulers.parallel()))
                .flatMap(f -> f)
                .doOnNext(System.out::println)
                .blockLast();
    }
}
