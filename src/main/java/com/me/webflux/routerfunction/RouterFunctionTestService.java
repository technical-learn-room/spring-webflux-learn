package com.me.webflux.routerfunction;

import org.springframework.stereotype.Service;

@Service
public class RouterFunctionTestService {

    public String combineName(String firstName, String lastName) {
        return lastName + firstName;
    }

    public String combineGradeClassNumber(int grade, int classroom, int number) {
        return String.format("%d%d%d", grade, classroom, number);
    }
}
