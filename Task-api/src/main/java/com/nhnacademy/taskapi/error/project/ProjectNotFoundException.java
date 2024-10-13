package com.nhnacademy.taskapi.error.project;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException() {
        super("선택한 프로젝트가 존재하지 않습니다.");
    }

    public ProjectNotFoundException(Long projectId) { super("선택한 아이디 : " + projectId + " 의 프로젝트를 찾을 수 없습니다."); }

    public ProjectNotFoundException(String message) {
        super(message, null);
    }
}
