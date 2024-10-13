package com.nhnacademy.taskapi.error.milestone;

public class MileStoneAlreadyExistsException extends RuntimeException {

    public MileStoneAlreadyExistsException() {
        super("이미 존재하는 마일스톤입니다.");
    }

    public MileStoneAlreadyExistsException(String message) {
        super(message);
    }
}
