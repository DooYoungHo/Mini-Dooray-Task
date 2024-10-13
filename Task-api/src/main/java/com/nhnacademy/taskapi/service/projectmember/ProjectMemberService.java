package com.nhnacademy.taskapi.service.projectmember;

import com.nhnacademy.taskapi.entity.project.Project;
import com.nhnacademy.taskapi.entity.projectmember.dto.ProjectMemberDto;
import com.nhnacademy.taskapi.entity.user.User;

import java.util.List;

public interface ProjectMemberService {

    ProjectMemberDto addMemberToProject(String ownerId, Long projectId, String userId);

    List<Project> getProjectsByUserId(String userId);

    List<User> getMembersByProjectId(Long projectId);
}
