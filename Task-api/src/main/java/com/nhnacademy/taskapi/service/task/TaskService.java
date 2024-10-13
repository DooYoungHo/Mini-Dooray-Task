package com.nhnacademy.taskapi.service.task;

import com.nhnacademy.taskapi.dto.task.RequestTaskCommand;
import com.nhnacademy.taskapi.dto.task.TaskDetailResponseDto;
import com.nhnacademy.taskapi.dto.task.TaskSimpleResponseDto;
import com.nhnacademy.taskapi.entity.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Page<TaskSimpleResponseDto> getTasksByProjectId(Long projectId, Pageable pageable);
    TaskDetailResponseDto getTaskById(Long taskId);
    Task createTask(RequestTaskCommand requestTaskCommand);
    boolean deleteTask(Long taskId);
    TaskDetailResponseDto updateTask(long taskId, RequestTaskCommand updateTaskCommand);
}
