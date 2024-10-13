package com.nhnacademy.taskapi.service.task.impl;

import com.nhnacademy.taskapi.dto.task.RequestTaskCommand;
import com.nhnacademy.taskapi.dto.task.TaskDetailResponseDto;
import com.nhnacademy.taskapi.dto.task.TaskSimpleResponseDto;
import com.nhnacademy.taskapi.entity.project.Project;
import com.nhnacademy.taskapi.entity.task.Task;
import com.nhnacademy.taskapi.repository.project.ProjectRepository;
import com.nhnacademy.taskapi.repository.task.TaskRepository;
import com.nhnacademy.taskapi.service.task.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Page<TaskSimpleResponseDto> getTasksByProjectId(Long projectId, Pageable pageable) {

        return taskRepository.findByProjectId(projectId, pageable);
    }

    @Override
    public TaskDetailResponseDto getTaskById(Long taskId) {

        Task taskDto = taskRepository.findByTaskId(taskId);
        TaskDetailResponseDto task = new TaskDetailResponseDto(taskDto);


        return task;
    }

    @Transactional
    @Override
    public Task createTask(RequestTaskCommand requestTaskCommand) {
        Project project = projectRepository.findById(requestTaskCommand.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));
        Task task = requestTaskCommand.toEntity(project);


        return taskRepository.save(task);
    }

    @Override
    public boolean deleteTask(Long taskId) {

        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isPresent()) {
            taskRepository.delete(taskOptional.get());
            return true;
        } else {
            return false;
        }
    }
    @Transactional  // 트랜잭션을 설정
    @Override
    public TaskDetailResponseDto updateTask(long taskId, RequestTaskCommand updateTaskCommand) {
        Project project = projectRepository.findById(updateTaskCommand.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        task.setTitle(updateTaskCommand.getTitle());
        task.setContent(updateTaskCommand.getContent());
        TaskDetailResponseDto taskDetailResponseDto = new TaskDetailResponseDto(task);
        taskDetailResponseDto.setProjectId(project.getProjectId());
        return taskDetailResponseDto;
    }


}
