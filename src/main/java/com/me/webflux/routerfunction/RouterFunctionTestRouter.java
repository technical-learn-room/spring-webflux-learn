package com.me.webflux.routerfunction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterFunctionTestRouter {

    @Bean
    public RouterFunction<?> route(RouterFunctionTestHandler testHandler) {
        return RouterFunctions.route()
                .POST(
                        "/test",
                        RequestPredicates.accept(MediaType.APPLICATION_JSON)
                                .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)),
                        testHandler::testHandler
                ).build();
    }
}
