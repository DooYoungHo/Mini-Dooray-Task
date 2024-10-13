package com.nhnacademy.taskapi.error.user;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
        super("이미 유저가 존재합니다.");
    }

    public UserAlreadyExistsException(String userId) {
        super("해당 아이디 (" + userId + ")가 존재합니다.");
    }
}
