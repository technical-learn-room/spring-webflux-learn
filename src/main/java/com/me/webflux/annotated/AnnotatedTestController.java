package com.me.webflux.annotated;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AnnotatedTestController {
    private final AnnotatedTestService testService;

    @PostMapping("/hello")
    public Mono<AnnotatedTestResponse> testController(@RequestBody Mono<AnnotatedTestRequest> request) {
        return request
                .flatMap(req -> Mono.just(
                        new AnnotatedTestResponse(
                                testService.combineName(req.getFirstName(), req.getLastName()),
                                req.getAge(),
                                testService.combineGradeClassNumber(req.getGrade(), req.getClassroom(), req.getNumber())
                        )
                ));
    }
}
