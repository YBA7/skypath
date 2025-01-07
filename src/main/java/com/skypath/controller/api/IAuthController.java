package com.skypath.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/auth")
public interface IAuthController {
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String login(@RequestParam String username, @RequestParam String password);
}
