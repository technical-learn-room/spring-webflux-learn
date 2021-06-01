package com.me.webflux.routerfunction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RouterFunctionTestRequest {
    private String firstName;
    private String lastName;
    private int age;
    private int grade;
    private int classroom;
    private int number;
}