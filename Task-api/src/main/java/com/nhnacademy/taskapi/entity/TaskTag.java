package com.nhnacademy.taskapi.entity;


import com.nhnacademy.taskapi.entity.task.Task;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TaskTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskTagId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)  // 외래키 지정
    private Task task;
}
