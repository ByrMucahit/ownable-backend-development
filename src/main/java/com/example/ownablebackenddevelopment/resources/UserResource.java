package com.example.ownablebackenddevelopment.resources;

import com.example.ownablebackenddevelopment.resources.model.UserResponse;
import com.example.ownablebackenddevelopment.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserResource {

    private UserService userService;

    public UserResource ( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<Set<UserResponse>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }
}
