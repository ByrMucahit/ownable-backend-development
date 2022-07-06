package com.example.ownablebackenddevelopment.service;

import com.example.ownablebackenddevelopment.domain.User;
import com.example.ownablebackenddevelopment.resources.model.UserRequest;
import com.example.ownablebackenddevelopment.resources.model.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    Set<UserResponse> findAllUser();

    Optional<UserResponse> saveUser(UserRequest userRequest);

    Optional<UserResponse> findUserByUserName(UserDetails userDetails);
}
