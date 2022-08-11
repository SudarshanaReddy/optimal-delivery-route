package com.optimaldelivery.controller;

import com.optimaldelivery.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.optimaldelivery.service.UserRegisterService;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/register")
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(final UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(this.userRegisterService.registerUser(user));
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(this.userRegisterService.getAllUsers());
    }

}
