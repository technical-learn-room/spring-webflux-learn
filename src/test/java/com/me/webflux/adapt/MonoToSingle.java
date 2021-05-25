package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Mono;

public class MonoToSingle {
    public static void main(String[] args) {
        Single.fromPublisher(Mono.just("apple"));
    }
}
