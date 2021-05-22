package com.me.webflux.step_verifier;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierUseAssertNextTest {

    @Test
    public void useAssertNextTest() {
        Flux<Box> flux = Flux.just(
                new Box("apple"),
                new Box("banana")
        );

        StepVerifier.create(flux)
                .assertNext(box ->  // assertNext()를 이용하여 org.assertj.core.api.Assertions 또는 org.junit.jupiter.api.Assertions API를 이용할 수 있다.
                        Assertions.assertThat(box.getElement())
                                .isEqualTo("apple"))
                .assertNext(box ->
                        Assertions.assertThat(box.getElement())
                                .isEqualTo("banana"))
                .verifyComplete();
    }

    public static class Box {
        private String element;

        public Box(String element) {
            this.element = element;
        }

        public String getElement() {
            return element;
        }
    }
}
