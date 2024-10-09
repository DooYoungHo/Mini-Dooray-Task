package com.nhnacademy.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    @NotNull
    @Setter
    @Length(max = 50)
    private String title;

    @NotNull
    @Setter
    private ProjectStatus status;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private String userId;

    public Project(String title, ProjectStatus status, String userId) {
        this.title = title;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.userId = userId;
    }
}
