package com.nhnacademy.taskapi.entity.project.dto;

import com.nhnacademy.taskapi.entity.project.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {

    private String title;
    private ProjectStatus status;

    public ProjectDto(String title, ProjectStatus status) {
        this.title = title;
        this.status = status;
    }
}
