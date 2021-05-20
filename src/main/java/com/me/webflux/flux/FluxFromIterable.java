package com.me.webflux.flux;

import reactor.core.publisher.Flux;

import java.util.List;

/*
public static <T> Flux<T> fromIterable(Iterable<? extends T> it)

Description
Create a Flux that emits the items contained in the provided Iterable.
The Iterable.iterator() method will be invoked at least once and at most twice for each subscriber.
This operator inspects the Iterable's Spliterator to assess if the iteration can be guaranteed to be finite
(see Operators.onDiscardMultiple(Iterator, boolean, Context)).
Since the default Spliterator wraps the Iterator we can have two Iterable.iterator() calls.
This second invocation is skipped on a Collection however, a type which is assumed to be always finite.

Discard Support
Upon cancellation, this operator attempts to discard the remainder of the Iterable if it can safely ensure the iterator is finite. Note that this means the Iterable.iterator() method could be invoked twice.

Type Parameters
T - The type of values in the source Iterable and resulting Flux

Parameters
it - the Iterable to read data from

Returns
a new Flux
 */

public class FluxFromIterable {
    public static void main(String[] args) {
        var list = List.of("apple", "banana", "grape", "melon", "mango");
        Flux.fromIterable(list)
                .doOnNext(System.out::println)
                .subscribe();
    }
}

/*
apple
banana
grape
melon
mango
 */