package com.example.ownablebackenddevelopment.service;

import com.example.ownablebackenddevelopment.resources.model.request.UserRequest;
import com.example.ownablebackenddevelopment.resources.model.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Optional<UserResponse> saveUser(UserRequest userRequest);
}
