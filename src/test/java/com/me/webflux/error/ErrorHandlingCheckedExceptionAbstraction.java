package com.me.webflux.error;

import org.junit.jupiter.api.Test;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;

public class ErrorHandlingCheckedExceptionAbstraction {

    @Test
    public void checkedExceptionAbstractionTest() {
        Flux.just("apple", "apple", "apple", "banana", "apple")
                .log()
                .map(fruit -> {
                    try {
                        return toPineapple(fruit);
                    } catch (NonAppleException e) {
                        throw Exceptions.propagate(e);
                    }
                })
                .doOnNext(System.out::println)
                .subscribe();
    }

    private String toPineapple(String fruit) throws NonAppleException {
        if (!fruit.equals("apple")) {
            throw new NonAppleException();
        }
        return "pineapple";
    }

    private static class NonAppleException extends Exception {}
}
