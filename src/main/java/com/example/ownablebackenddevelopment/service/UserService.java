package com.example.ownablebackenddevelopment.service;

import com.example.ownablebackenddevelopment.resources.model.UserResponse;

import java.util.List;
import java.util.Set;

public interface UserService {

    Set<UserResponse> findAllUser();
}
