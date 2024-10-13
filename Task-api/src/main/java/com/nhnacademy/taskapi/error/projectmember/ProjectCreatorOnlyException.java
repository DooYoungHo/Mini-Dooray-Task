package com.nhnacademy.taskapi.error.projectmember;

public class ProjectCreatorOnlyException extends RuntimeException {

    public ProjectCreatorOnlyException() {
        super("프로젝트 관리자만이 생성할 수 있습니다.");
    }
}
