package com.example.ownablebackenddevelopment.service.impl;
import com.amazonaws.services.cognitoidp.model.UserNotFoundException;
import com.example.ownablebackenddevelopment.domain.User;
import com.example.ownablebackenddevelopment.exception.EmptyObjectException;
import com.example.ownablebackenddevelopment.exception.UserNotFoundExcepiton;
import com.example.ownablebackenddevelopment.repository.UserRepository;
import com.example.ownablebackenddevelopment.resources.model.request.UserRequest;
import com.example.ownablebackenddevelopment.resources.model.response.UserResponse;
import com.example.ownablebackenddevelopment.service.UserService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;

    private final String ENTITY_NAME = "USER SERVICE IMPL";

    public UserServiceImpl ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<UserResponse> saveUser(UserRequest userRequest) {

        if(Objects.isNull(userRequest)) {
            throw new EmptyObjectException("OBJECT CANNOT BE EMPTY");
        }
        var user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());

        var response = userRepository.save(user);

        var userResponse = new UserResponse();
        userResponse.setFirstName(response.getFirstName());
        userResponse.setLastName(response.getLastName());

        return Optional.of(userResponse);
    }

}
