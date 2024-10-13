package com.nhnacademy.taskapi.service.project;

import com.nhnacademy.taskapi.entity.project.Project;
import com.nhnacademy.taskapi.entity.project.ProjectStatus;
import com.nhnacademy.taskapi.entity.project.dto.ProjectDto;
import com.nhnacademy.taskapi.entity.user.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    List<ProjectDto> getAllActiveProjects();

    List<ProjectDto> getAllInactiveProjects();

    List<ProjectDto> getAllTerminatedProjects();

    List<ProjectDto> getAllActiveProjectsByUser(String userId);

    List<ProjectDto> getAllInactiveProjectsByUser(String userId);

    List<ProjectDto> getAllTerminatedProjectsByUser(String userId);

    List<Project> getProjectsByUserId(String userId);

    Page<Project> getProjectsPage(Pageable pageable);

    Project getProjectById(Long projectId);

    Project create(String title, ProjectStatus projectStatus, String userId);

    void delete(Long projectId, String userId);

    void update(Long projectId, String title, ProjectStatus status, String userId);

    UserDto getCreateUserByProjectId(Long projectId);
}
