package com.nikita.lab.userservice.controller;

import com.nikita.lab.userservice.model.User;
import com.nikita.lab.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        URI location = URI.create("/api/users/" + createdUser.getId());

        return ResponseEntity
                .created(location)
                .body(createdUser);
    }
}
