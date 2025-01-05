package com.skypath.skypath.controller.api;

import com.skypath.skypath.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface IUserController {
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest);
}
