package com.nhnacademy.taskapi.error.projectmember;

public class ProjectMemberAlreadyExistException extends RuntimeException {

    public ProjectMemberAlreadyExistException() {
        super("이미 해당 멤버는 프로젝트에 참여 중입니다.");
    }

    public ProjectMemberAlreadyExistException(String userId) {
        super("해당 유저 : " + userId + "는 프로젝트에 참여 중입니다.");
    }
}
