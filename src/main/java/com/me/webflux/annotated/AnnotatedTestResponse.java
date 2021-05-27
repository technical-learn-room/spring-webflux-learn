package com.me.webflux.annotated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TestResponse {
    private String name;
    private int age;
    private String gradeClassNumber;
}
