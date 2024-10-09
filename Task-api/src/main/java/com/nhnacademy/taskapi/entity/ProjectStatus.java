package com.nhnacademy.project.entity;

import lombok.Getter;

@Getter
public enum ProjectStatus {
    ACTIVE(1),
    INACTIVE(2),
    TERMINATED(3);

    private final Integer projectStatus;

    private ProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

}
