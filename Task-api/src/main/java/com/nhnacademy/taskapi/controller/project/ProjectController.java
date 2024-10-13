package com.nhnacademy.taskapi.controller.project;

import com.nhnacademy.taskapi.entity.project.Project;
import com.nhnacademy.taskapi.entity.project.request.ProjectRequest;
import com.nhnacademy.taskapi.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects")        /* 모든 프로젝트 목록 조회 */
    public ResponseEntity<?> getProjects(Pageable pageable,
                                        @RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "size", required = false) Integer size
    ) {
        if (Objects.isNull(page) && Objects.isNull(size)) {
            return ResponseEntity.ok(projectService.getAllProjects());
        } else {
            return ResponseEntity.ok(projectService.getProjectsPage(pageable));
        }
    }

    @PostMapping("/projects")       /* 특정 프로젝트 생성 */
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        Project project = projectService.create(projectRequest.getTitle(), projectRequest.getStatus(), projectRequest.getUserId());
        return ResponseEntity.ok(project);
    }

    @GetMapping("/projects/{projectId}") /* 특정 프로젝트 조회 */
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping("/projects/user/{userId}") /* 특정 유저가 만든 프로젝트 목록 조회 */
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(projectService.getProjectsByUserId(userId));
    }

    @DeleteMapping("/projects/{projectId}") /* 프로젝트 삭제 */
    public ResponseEntity<?> deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.delete(projectId);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/projects/{projectId}")    /* 프로젝트 업데이트 */
    public ResponseEntity<?> updateProject(@PathVariable("projectId") Long projectId,
                                           @RequestBody ProjectRequest projectRequest) {
        projectService.update(projectId, projectRequest.getTitle(), projectRequest.getStatus(), projectRequest.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
