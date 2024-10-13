package com.nhnacademy.taskapi.entity.project.request;

import com.nhnacademy.taskapi.entity.project.ProjectStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProjectCreateRequest {
    private String title;
    private ProjectStatus status;

    public ProjectCreateRequest(String title, Integer status) {
        this.title = title;
        this.status = ProjectStatus.fromValue(status);

    }
}
