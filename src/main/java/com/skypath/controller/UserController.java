package com.skypath.controller;

import com.skypath.controller.api.IUserController;
import com.skypath.dto.request.UserRequest;
import com.skypath.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService userService;

    @Override
    public String createUser(UserRequest userRequest) {
        userService.createUser(userRequest);
        return "User created successfully";
    }
}
