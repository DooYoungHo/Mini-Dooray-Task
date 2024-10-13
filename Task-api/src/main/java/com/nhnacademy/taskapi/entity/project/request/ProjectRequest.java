package com.nhnacademy.taskapi.entity.project.request;

import com.nhnacademy.taskapi.entity.project.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {

    private String title;
    private ProjectStatus status;
    private String userId;

    public ProjectRequest(String title, Integer status, String userId) {
        this.title = title;
        this.status = ProjectStatus.fromValue(status);
        this.userId = userId;
    }
}
