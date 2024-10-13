package com.nhnacademy.taskapi.entity;


import com.nhnacademy.taskapi.entity.task.Task;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)  // 외래키 지정
    private Task task;
}
