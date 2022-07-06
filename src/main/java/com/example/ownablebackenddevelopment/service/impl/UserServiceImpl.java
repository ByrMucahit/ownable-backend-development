package com.example.ownablebackenddevelopment.service.impl;
import com.amazonaws.services.cognitoidp.model.UserNotFoundException;
import com.example.ownablebackenddevelopment.domain.User;
import com.example.ownablebackenddevelopment.exception.EmptyObjectException;
import com.example.ownablebackenddevelopment.exception.UserNotFoundExcepiton;
import com.example.ownablebackenddevelopment.repository.UserRepository;
import com.example.ownablebackenddevelopment.resources.model.UserRequest;
import com.example.ownablebackenddevelopment.resources.model.UserResponse;
import com.example.ownablebackenddevelopment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

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
    public Set<UserResponse> findAllUser() {

        var response = userRepository.findAll();


        if(response.isEmpty()) {
            throw new UserNotFoundExcepiton(ENTITY_NAME, "USER NOT FOUND", "UNKNOW USER");
        }

        HashSet<UserResponse> responseList = new HashSet<>();
        response.stream().map(iter -> {
            var userResponse = new UserResponse();
            userResponse.setLastName(iter.getLastName());
            userResponse.setFirstName(iter.getFirstName());
            responseList.add(userResponse);
            return iter;
        }).toList();

        return responseList;
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

    @Override
    public Optional<UserResponse> findUserByUserName(UserDetails userDetails) {

        var user = userRepository
                .findOneByLogin(userDetails.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + userDetails.getUsername()));
        return Optional.empty();
    }

    private String passwordEncoding (String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        return encodedPassword;
    }
}
