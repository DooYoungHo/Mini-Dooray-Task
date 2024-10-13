package com.nhnacademy.taskapi.repository.projectmember;

import com.nhnacademy.taskapi.entity.project.Project;
import com.nhnacademy.taskapi.entity.projectmember.ProjectMember;
import com.nhnacademy.taskapi.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    boolean existsByUser_UserId(String userId);

    @Query("SELECT pm.project FROM ProjectMember pm WHERE pm.user.userId = :userId")
    List<Project> findProjectParticipationByUserId(String userId);

    @Query("SELECT pm.user FROM ProjectMember pm WHERE pm.project.projectId = :projectId")
    List<User> findUserParticipationByProjectId(Long projectId);
}
