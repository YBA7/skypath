package com.skypath.skypath.controller;

import com.skypath.skypath.controller.api.IUserController;
import com.skypath.skypath.request.UserRequest;
import com.skypath.skypath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService userService;

    @Override
    public ResponseEntity<String> createUser(UserRequest userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.ok("User created successfully");
    }
}
