package com.mindzone.backend.service;

import com.mindzone.backend.dto.UserCreateDto;
import com.mindzone.backend.dto.UserDto;
import com.mindzone.backend.dto.UserLoginDto;

import java.util.UUID;

public interface UserService {

    UUID createUser(UserCreateDto userCreateDto);

    UserDto loginUser(UserLoginDto userLoginDto);

}
