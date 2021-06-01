package com.me.webflux.routerfunction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RouterFunctionTestHandler {

    private final RouterFunctionTestService testService;

    public Mono<ServerResponse> testHandler(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request.bodyToMono(RouterFunctionTestRequest.class).flatMap(req -> Mono.just(
                        new RouterFunctionTestResponse(
                                testService.combineName(req.getFirstName(), req.getLastName()),
                                req.getAge(),
                                testService.combineGradeClassNumber(req.getGrade(), req.getClassroom(), req.getNumber())
                        )
                )), RouterFunctionTestResponse.class);
    }
}
