package com.nhnacademy.taskapi.entity.task;

import com.nhnacademy.taskapi.dto.task.TaskSimpleResponseDto;
import com.nhnacademy.taskapi.entity.Comment;
import com.nhnacademy.taskapi.entity.TaskTag;
import com.nhnacademy.taskapi.entity.project.Project;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;

    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    private String content;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)  // 외래키 지정
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaskTag> taskTags;

    public Task(long taskId, String title, String content, ZonedDateTime createdAt, Project projet) {
        this.taskId = taskId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.project = projet;
    }

    public Task(String title, String content, Project project) {
        this.title = title;
        this.content = content;
        this.createdAt = ZonedDateTime.now();
        this.project = project;
    }
}
