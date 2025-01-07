package com.skypath.service.impl;

import com.skypath.dto.request.UserRequest;
import com.skypath.entity.User;
import com.skypath.mapper.UserMapper;
import com.skypath.repository.UserRepository;
import com.skypath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
        if (userRequest.getRole().startsWith("ROLE_")) {
            throw new IllegalArgumentException("Role must not start with 'ROLE_'.");
        }
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
    }
}

