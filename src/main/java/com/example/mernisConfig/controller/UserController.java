package com.example.mernisConfig.controller;

import com.example.mernisConfig.mernis.JSGKPSPublicSoap;
import com.example.mernisConfig.model.User;
import com.example.mernisConfig.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.registerUser(user));
}}
