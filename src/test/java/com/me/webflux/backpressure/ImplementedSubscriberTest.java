package com.me.webflux.backpressure;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ImplementedSubscriberTest {

    @Test
    public void implementedSubscriberTest() {
        Flux.just("apple", "banana", "grape", "melon", "mango",
                "strawberry", "watermelon", "kiwi", "eggplant", "lemon",
                "peach")
                .log()
                .doOnNext(System.out::println)
                .subscribe(new Subscriber<>() {
                    private Subscription subscription;
                    private long count = 0;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(5);
                    }

                    @Override
                    public void onNext(String s) {
                        count++;
                        if (count % 5 == 0) {
                            this.subscription.request(5);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("처리 실패");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("처리 성공");
                    }
                });
    }
}
