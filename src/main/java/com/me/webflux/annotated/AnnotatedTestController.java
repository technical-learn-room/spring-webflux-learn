package com.me.webflux.annotated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AnnotatedController {

    @GetMapping("/hello")
    public Mono<TestResponse> annotatedController(@RequestBody AnnotatedRequest request) {
        return Mono.just(new TestResponse("이진혁", 19, "3417"));
    }
}
