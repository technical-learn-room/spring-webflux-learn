package com.me.webflux.adapt;

import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Mono;

public class SingleToMono {
    public static void main(String[] args) {
        Mono.from(Single.just("apple").toFlowable());
    }
}
