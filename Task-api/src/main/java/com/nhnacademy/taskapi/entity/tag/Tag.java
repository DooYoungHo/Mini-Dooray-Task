package com.nhnacademy.taskapi.entity.tag;

import com.nhnacademy.taskapi.entity.project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Tag", uniqueConstraints = {
        @UniqueConstraint(columnNames = "content")
})
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    @Setter
    @Column(nullable = false, length = 50)
    private String content;

    @Setter
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    public Tag(String content, Project project) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.project = project;
    }

}
