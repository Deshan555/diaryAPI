package com.weblog.diary.exception;

public class ContentNotFoundException extends RuntimeException{
    public ContentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
