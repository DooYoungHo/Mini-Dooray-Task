package com.nhnacademy.taskapi.controller.user;

import com.nhnacademy.taskapi.entity.user.dto.UserDto;
import com.nhnacademy.taskapi.entity.user.request.UserRequest;
import com.nhnacademy.taskapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")              /* 유저 등록하기 */
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        UserDto userDto = userService.save(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @DeleteMapping("/users")           /* 유저 삭제하기 */
    public ResponseEntity<?> deleteUser(@RequestHeader("X-USER-ID") String userId) {
        userService.delete(userId);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/users/{userId}")              /* 유저 조회 */
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
