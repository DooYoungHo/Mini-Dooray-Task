package com.nhnacademy.taskapi.error.tag;

public class TagAlreadyExistsException extends RuntimeException {

    public TagAlreadyExistsException() {
        super("이미 존재하는 태그입니다.");
    }

    public TagAlreadyExistsException(String message) {
        super(message);
    }
}
