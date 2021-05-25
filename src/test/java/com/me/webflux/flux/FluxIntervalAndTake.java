package com.me.webflux.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import java.time.Duration;

/*
public static Flux<Long> interval(Duration period)

Description
Create a Flux that emits long values starting with 0 and incrementing at specified time intervals on the global timer. The first element is emitted after an initial delay equal to the period. If demand is not produced in time, an onError will be signalled with an overflow IllegalStateException detailing the tick that couldn't be emitted. In normal conditions, the Flux will never complete.
Runs on the Schedulers.parallel() Scheduler.

Parameters
period - the period Duration between each increment

Returns
a new Flux emitting increasing numbers at regular intervals
 */

/*
public final Flux<T> take(long n)

Description
Take only the first N values from this Flux, if available.
If n is zero, the source is subscribed to but immediately cancelled, then the operator completes.

Warning
The below behavior will change in 3.5.0 from that of take(n, false) to that of take(n, true).
See https://github.com/reactor/reactor-core/issues/2339

Note that this operator doesn't propagate the backpressure requested amount.
Rather, it makes an unbounded request and cancels once N elements have been emitted.
As a result, the source could produce a lot of extraneous elements in the meantime.
If that behavior is undesirable and you do not own the request from downstream (e.g. prefetching operators),
consider using limitRequest(long) instead.

Parameters
n - the number of items to emit from this Flux

Returns
a Flux limited to size N
 */

public class FluxIntervalAndTake {

    @Test
    public void test() throws InterruptedException {
        Flux.interval(Duration.ofMillis(1000))  // 1초 마다 데이터를 생성하는 무한한 데이터 스트림을 생성
                .take(5)                        // 무한한 스트림 중 5개를 제한적으로 데이터 스트림을 생성
                .doOnNext(System.out::println)  // 출력
                .subscribe();         

        Thread.sleep(10000);               // asynchronous 하게 동작하기 때문에 프로그램이 멈추지 않도록 쓰레드를 멈춤
    }
}

/*
1000ms 즉, 1초를 주기로 출력합니다.
0
1
2
3
4
 */