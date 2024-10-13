package com.nhnacademy.taskapi.user;


import com.nhnacademy.taskapi.entity.user.User;
import com.nhnacademy.taskapi.entity.user.dto.UserDto;
import com.nhnacademy.taskapi.entity.user.request.UserRequest;
import com.nhnacademy.taskapi.repository.project.ProjectRepository;
import com.nhnacademy.taskapi.repository.projectmember.ProjectMemberRepository;
import com.nhnacademy.taskapi.repository.user.UserRepository;
import com.nhnacademy.taskapi.service.user.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectMemberRepository projectMemberRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Save User")
    void saveUser() {
        UserRequest userRequest = new UserRequest("testId");

        when(userRepository.existsById("testId")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(new User("testId"));

        UserDto userDto = userService.save(userRequest);

        assertNotNull(userDto);
        assertEquals("testId", userDto.getUserId());
    }

    @Test
    @DisplayName("Delete User")
    void deleteUser() {
        UserRequest userRequest = new UserRequest("testId");

        when(userRepository.existsById("testId")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(new User("testId"));

        userService.save(userRequest);

        userService.delete("testId");

        assertNull(userService.getUser("testId"));
    }
}
