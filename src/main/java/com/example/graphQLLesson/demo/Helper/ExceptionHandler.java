package com.example.graphQLLesson.demo.Helper;

public class ExceptionHandler {

    public static RuntimeException throwResourceNotFoundException()
    {
        return new RuntimeException("Resource Not Found");
    }
}
