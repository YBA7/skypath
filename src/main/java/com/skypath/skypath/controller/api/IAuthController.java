package com.skypath.skypath.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/auth")
public interface IAuthController {
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestParam String username, @RequestParam String password);
}
