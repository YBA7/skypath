package com.skypath.controller.api;

import com.skypath.dto.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/user")
public interface IUserController {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    String createUser(@RequestBody @Valid UserRequest userRequest);
}
