package com.example.ownablebackenddevelopment.service.impl;

import com.example.ownablebackenddevelopment.exception.UserNotFoundExcepiton;
import com.example.ownablebackenddevelopment.repository.UserRepository;
import com.example.ownablebackenddevelopment.resources.model.UserResponse;
import com.example.ownablebackenddevelopment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
