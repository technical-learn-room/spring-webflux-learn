package com.me.webflux.annotated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AnnotatedTestRequest {
    private String firstName;
    private String lastName;
    private int age;
    private int grade;
    private int classroom;
    private int number;
}
