package com.mindzone.backend.service.impl;

import com.mindzone.backend.dto.UserCreateDto;
import com.mindzone.backend.dto.UserDto;
import com.mindzone.backend.dto.UserLoginDto;
import com.mindzone.backend.repository.UserRepository;
import com.mindzone.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID createUser(UserCreateDto userCreateDto) {
        return userRepository.createUser(userCreateDto);
    }

    @Override
    public UserDto loginUser(UserLoginDto userLoginDto) {
        return userRepository.loginUser(userLoginDto);
    }
}
