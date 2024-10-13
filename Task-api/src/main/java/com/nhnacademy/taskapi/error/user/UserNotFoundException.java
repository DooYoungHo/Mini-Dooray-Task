package com.nhnacademy.taskapi.error.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("유저를 찾을 수 없습니다.");
    }

    public UserNotFoundException(String userId) {
        super("유저 아이디 : " + userId + " 로 등록된 유저를 찾을 수 없습니다.");
    }

}
