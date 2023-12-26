package com.mindzone.backend.controller;

import com.mindzone.backend.api.UserApi;
import com.mindzone.backend.dto.UserCreateDto;
import com.mindzone.backend.dto.UserDto;
import com.mindzone.backend.dto.UserLoginDto;
import com.mindzone.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController implements UserApi {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UUID> createUser(UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    @Override
    public ResponseEntity<UserDto> loginUser(UserLoginDto userLoginDto) {
        return ResponseEntity.ok(userService.loginUser(userLoginDto));
    }
}
