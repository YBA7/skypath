package com.skypath.skypath.service.impl;

import com.skypath.skypath.entity.User;
import com.skypath.skypath.mapper.UserMapper;
import com.skypath.skypath.repository.UserRepository;
import com.skypath.skypath.request.UserRequest;
import com.skypath.skypath.service.UserService;
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
        //ROLE 'E ROLE İLE BAŞLAMAMISI SAĞLA SECURİTY PATLAR.
        User user = userMapper.toEntity(userRequest);
        userRepository.save(user);
    }
}

