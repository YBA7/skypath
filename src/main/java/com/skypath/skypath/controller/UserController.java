package com.skypath.skypath.controller;

import com.skypath.skypath.controller.api.IUserController;
import com.skypath.skypath.repository.UserRepository;
import com.skypath.skypath.request.UserRequest;
import com.skypath.skypath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> createUser(UserRequest userRequest) {
        String username = String.valueOf(userRepository.findByUsername(userRequest.getUsername()));
        if (Objects.nonNull(username)) {
            throw new RuntimeException("User with the same name already exists.");
        }

        userService.createUser(userRequest);
        return ResponseEntity.ok("User created successfully");
    }
}
