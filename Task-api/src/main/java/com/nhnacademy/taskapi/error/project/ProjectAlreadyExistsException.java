package com.nhnacademy.taskapi.error.project;

public class ProjectAlreadyExistsException extends RuntimeException {
    public ProjectAlreadyExistsException() {
        super("해당 프로젝트가 이미 존재합니다.");
    }

    public ProjectAlreadyExistsException(String message) {
        super(message, null);
    }
}
